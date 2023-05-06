package org.demo.message;

import lombok.val;
import org.demo.message.domain.repository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest(classes = SpringBootApplication.class)
@EnableJpaRepositories(basePackages = "org.demo.message.infrastructure")
public class JpaTest {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void test() {
        val result = messageRepository.findMessageList(1);
        System.out.println(result);
    }
}
