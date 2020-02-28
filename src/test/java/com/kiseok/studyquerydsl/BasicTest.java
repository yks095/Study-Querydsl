package com.kiseok.studyquerydsl;

import com.kiseok.studyquerydsl.domain.Academy;
import com.kiseok.studyquerydsl.repository.AcademyRepository;
import com.kiseok.studyquerydsl.repository.AcademyRepositorySupport;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicTest {

    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private AcademyRepositorySupport academyRepositorySupport;

    @After
    public void tearDown() throws Exception {
        academyRepository.deleteAllInBatch();
    }

    @Test
    public void querydsl_기본_기능_확인() {
        // Given
        String name = "kiseok";
        String address = "kiseok@email.com";
        academyRepository.save(new Academy(name, address));

        // When
        List<Academy> result = academyRepositorySupport.findByName(name);

        // Then
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getAddress(), address);
    }
}
