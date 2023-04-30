package org.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.demo.mapper.MessageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MessageTest {
    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void testSelect() {
        List<org.demo.entity.db.Message> messageList = messageMapper.selectList(null);
        messageList.forEach(System.out::println);
    }
}
