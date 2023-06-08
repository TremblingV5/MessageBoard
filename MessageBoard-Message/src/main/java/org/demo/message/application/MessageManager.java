package org.demo.message.application;

import lombok.extern.slf4j.Slf4j;
import org.demo.interfaces.entity.response.AddMessageResponse;
import org.demo.interfaces.entity.response.ListMessageResponse;
import org.demo.message.domain.MessageDomainService;
import org.demo.message.domain.model.Message;
import org.demo.message.infrastructure.cache.RedisUtil;
import org.demo.message.infrastructure.mq.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class MessageManager {

    @Autowired
    private MessageDomainService messageDomainService;

    @Autowired
    private RedisUtil<org.demo.interfaces.entity.pojo.Message> redisUtil;

    @Autowired
    private KafkaSender<org.demo.interfaces.entity.pojo.Message> kafkaSender;

    public ListMessageResponse ListMessage(int pageNum) {
        List<org.demo.interfaces.entity.pojo.Message> result = redisUtil.getList("cache");

        if (result == null || result.size() <= 0) {
            log.info("list message missed cache");

            List<Message> messageList = messageDomainService.getMessageList(pageNum);
            for (Message Message : messageList) {
                result.add(
                        Message.toDto()
                );
            }

            redisUtil.set("cache", result);
        } else {
            log.info("list message hit cache");
        }

        return ListMessageResponse.builder().messageList(result).build();
    }

    public AddMessageResponse AddMessage(String content, String user) {
        redisUtil.del("cache");
        log.info("del cache before add");

        kafkaSender.send("message-board", org.demo.interfaces.entity.pojo.Message.builder()
                .content(content)
                .user(user)
                .build()
        );

        return AddMessageResponse.builder().message(
                org.demo.interfaces.entity.pojo.Message.builder()
                        .content(content)
                        .user(user)
                        .time("刚刚")
                        .build()
        ).build();
    }
}
