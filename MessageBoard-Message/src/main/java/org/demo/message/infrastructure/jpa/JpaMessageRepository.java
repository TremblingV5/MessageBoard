package org.demo.message.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.demo.message.domain.model.Message;

public interface JpaMessageRepository extends JpaRepository<Message, Long> {
}
