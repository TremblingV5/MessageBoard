package org.demo.message.application;

import org.apache.dubbo.config.annotation.DubboService;
import org.demo.interfaces.entity.request.AddMessageRequest;
import org.demo.interfaces.entity.request.ListMessageRequest;
import org.demo.interfaces.entity.response.AddMessageResponse;
import org.demo.interfaces.entity.response.ListMessageResponse;
import org.demo.message.domain.MessageDomainService;
import org.demo.message.domain.model.Message;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@DubboService(interfaceClass = org.demo.interfaces.protocol.MessageServiceImpl.class)
public class MessageManager implements org.demo.interfaces.protocol.MessageServiceImpl {

    @Autowired
    private MessageDomainService messageDomainService;

    @Override
    public ListMessageResponse ListMessage(ListMessageRequest request) {
        List<Message> messageList = messageDomainService.getMessageList(request.getPage());

        List<org.demo.interfaces.entity.pojo.Message> result = new ArrayList<>();
        for (Message message: messageList) {
            result.add(
                    message.toDto()
            );
        }

        return ListMessageResponse.builder().messageList(result).build();
    }

    @Override
    public AddMessageResponse AddMessage(AddMessageRequest request) {
        Message newMessage = messageDomainService.addMessage(
                Message.builder()
                        .content(request.getContent())
                        .user(request.getUser())
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
