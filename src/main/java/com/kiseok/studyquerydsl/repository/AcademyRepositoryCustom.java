package com.kiseok.studyquerydsl.repository;

import com.kiseok.studyquerydsl.domain.Academy;
import java.util.List;

public interface AcademyRepositoryCustom {
    List<Academy> findByName(String name);
}
