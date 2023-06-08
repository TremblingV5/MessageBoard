package org.demo.message.infrastructure.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.demo.interfaces.entity.pojo.Message;
import org.demo.message.domain.MessageDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {
    @Autowired
    private MessageDomainService messageDomainService;

    @KafkaListener(topics = "message-board", groupId = "message-application")
    @Async
    public void saveNewMessage(ConsumerRecord<String, org.demo.interfaces.entity.pojo.Message> message) {
        log.info("Get new message: {}, {}", message.value().getContent(), message.value().getUser());

        try {
            messageDomainService.addMessage(
                    org.demo.message.domain.model.Message.builder()
                            .content(message.value().getContent())
                            .user(message.value().getUser())
                            .build()
            );
            log.info("Save new message success");
        } catch (Exception e) {
            log.error("Save new message defeat: {}", e.getMessage());
        }



    }
}
