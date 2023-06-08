package org.demo.message.infrastructure.mq;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class KafkaSender<T> {
    @Autowired
    private KafkaTemplate<String, T> kafkaTemplate;

    public void send(final String key, T value) {
        try {
            ListenableFuture<SendResult<String, T>> listenableFuture = kafkaTemplate.send(key, value);
            listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, T>>() {
                @Override
                public void onFailure(@NonNull Throwable ex) {
                    log.error("Kafka send defeat by: {}", ex.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, T> result) {
                    log.info("Kafka send successfully");
                }
            });
        } catch (Exception e) {
            log.info("Kafka send defeat");
            e.printStackTrace();
        }
    }
}
