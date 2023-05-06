package org.demo.message.infrastructure.jpa;

import org.demo.message.domain.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QueryDSLRepository extends JpaRepository<Message, Long>, QuerydslPredicateExecutor<Message> {
}
