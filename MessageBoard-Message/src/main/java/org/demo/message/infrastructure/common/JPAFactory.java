package org.demo.message.infrastructure.common;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class JPAFactory {
//    @Resource
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Bean
//    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
//        return new JPAQueryFactory(entityManager);
//    }
}
