package org.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.demo.mapper.MessageMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@EnableDubbo
@MapperScan("org.demo.mapper")
public class Message {
    public static void main(String[] args) {
        SpringApplication.run(Message.class, args);
    }
}
