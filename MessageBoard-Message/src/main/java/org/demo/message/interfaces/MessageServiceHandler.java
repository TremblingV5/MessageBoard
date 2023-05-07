package org.demo.message.interfaces;

import org.apache.dubbo.config.annotation.DubboService;
import org.demo.interfaces.entity.request.AddMessageRequest;
import org.demo.interfaces.entity.request.ListMessageRequest;
import org.demo.interfaces.entity.response.AddMessageResponse;
import org.demo.interfaces.entity.response.ListMessageResponse;
import org.demo.message.application.MessageManager;
import org.demo.message.domain.MessageDomainService;
import org.demo.message.domain.model.Message;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@DubboService(interfaceClass = org.demo.interfaces.protocol.MessageServiceImpl.class)
public class MessageServiceHandler implements org.demo.interfaces.protocol.MessageServiceImpl {

    @Autowired
    private MessageManager messageManager;

    @Override
    public ListMessageResponse ListMessage(ListMessageRequest request) {
        return messageManager.ListMessage(request.getPage());
    }

    @Override
    public AddMessageResponse AddMessage(AddMessageRequest request) {
        return messageManager.AddMessage(request.getContent(), request.getUser());
    }
}
