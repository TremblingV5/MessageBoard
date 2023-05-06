package org.demo.message;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableDubbo
@Configuration
@AutoConfiguration
@EntityScan(basePackages = "org.demo.message.domain.model")
public class Message {
    public static void main(String[] args) {
        SpringApplication.run(Message.class, args);
    }
}
