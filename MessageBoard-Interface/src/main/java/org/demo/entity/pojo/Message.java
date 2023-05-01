package org.demo.entity.pojo;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class Message implements Serializable {
    private Long id;
    private String content;
    private String user;
    private String time;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getUser() {
        return user;
    }

    public String getTime() {
        return time;
    }

    public Message(Long id, String content, String user, String time) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.time = time;
    }
}
