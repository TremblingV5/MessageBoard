package org.demo.message.application;

import org.demo.interfaces.entity.response.AddMessageResponse;
import org.demo.interfaces.entity.response.ListMessageResponse;
import org.demo.message.domain.MessageDomainService;
import org.demo.message.domain.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageManager {

    @Autowired
    private MessageDomainService messageDomainService;

    public ListMessageResponse ListMessage(int pageNum) {
        List<Message> MessageList = messageDomainService.getMessageList(pageNum);

        List<org.demo.interfaces.entity.pojo.Message> result = new ArrayList<>();
        for (Message Message : MessageList) {
            result.add(
                    Message.toDto()
            );
        }

        return ListMessageResponse.builder().messageList(result).build();
    }

    public AddMessageResponse AddMessage(String content, String user) {
        Message newMessage = messageDomainService.addMessage(
                Message.builder()
                        .content(content)
                        .user(user)
                        .build()
        );
               return AddMessageResponse.builder().message(
                org.demo.interfaces.entity.pojo.Message.builder()
                        .id(newMessage.getId())
                        .content(newMessage.getContent())
                        .user(newMessage.getUser())
                        .time("刚刚")
                        .build()
        ).build();
    }
}
