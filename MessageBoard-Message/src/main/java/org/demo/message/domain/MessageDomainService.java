package org.demo.message.domain;

import org.demo.message.domain.model.Message;

import java.util.List;

public interface MessageDomainService {
    List<Message> getMessageList(int pageNum);
    Message addMessage(Message message);
}
