package org.demo.message.domain;

import org.demo.message.domain.model.Message;
import org.demo.message.domain.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageDomainServiceImpl implements MessageDomainService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> getMessageList(int pageNum) {
        return messageRepository.findMessageList(pageNum);
    }

    @Override
    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }
}
