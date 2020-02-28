package com.kiseok.studyquerydsl.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QuerydslConfiguration {    // 어디에서나 JpaQueryFactory를 주입받아 Querydsl을 사용할 수 있음

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory()    {
        return new JPAQueryFactory(entityManager);
    }
}
