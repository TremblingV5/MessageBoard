package org.demo.handler;

import org.apache.dubbo.config.annotation.DubboService;
import org.demo.common.PageUtil;
import org.demo.entity.pojo.Message;
import org.demo.entity.request.AddMessageRequest;
import org.demo.entity.request.ListMessageRequest;
import org.demo.service.db.MessageService;
import org.demo.entity.response.AddMessageResponse;
import org.demo.entity.response.ListMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@DubboService
public class MessageServiceImpl implements org.demo.protocol.MessageServiceImpl {

    @Autowired
    private MessageService messageService;

    @Override
    public ListMessageResponse ListMessage(ListMessageRequest request) {
        List<org.demo.entity.db.Message> messageList = messageService.getMessageList();

        PageUtil<org.demo.entity.db.Message> pageUtil = new PageUtil<>(request.getPage(), 5, messageList.size(), messageList);

        List<Message> result = new ArrayList<>();
        for (org.demo.entity.db.Message message: messageList.subList(pageUtil.getStart(), pageUtil.getStart() + 5)) {
            result.add(
                    new Message(message.getId(), message.getContent(), message.getUser(), message.getTimeInterval())
            );
        }

        return new ListMessageResponse(result);
    }

    @Override
    public AddMessageResponse AddMessage(AddMessageRequest request) {
        org.demo.entity.db.Message newMessage = messageService.addMessage(request.getContent(), request.getUser());

        return new AddMessageResponse(new Message(
                newMessage.getId(), newMessage.getContent(), newMessage.getUser(), "刚刚"
        ));
    }
}