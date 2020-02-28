package com.kiseok.studyquerydsl.repository;

import com.kiseok.studyquerydsl.domain.Academy;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import java.util.List;
import static com.kiseok.studyquerydsl.domain.QAcademy.academy;

@Repository
public class AcademyRepositorySupport extends QuerydslRepositorySupport {

    private JPAQueryFactory queryFactory;

    public AcademyRepositorySupport(JPAQueryFactory queryFactory) {
        super(Academy.class);
        this.queryFactory = queryFactory;
    }

    public List<Academy> findByName(String name)    {
        return queryFactory
                .selectFrom(academy)
                .where(academy.name.eq(name))
                .fetch();
    }

}
