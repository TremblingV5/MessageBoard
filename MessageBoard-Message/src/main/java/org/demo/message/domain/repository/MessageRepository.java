package org.demo.message.domain.repository;

import org.demo.message.domain.model.Message;

import java.util.List;

public interface MessageRepository {
    Message save(Message Message);
    List<Message> findMessageList(int pageNum);
}
