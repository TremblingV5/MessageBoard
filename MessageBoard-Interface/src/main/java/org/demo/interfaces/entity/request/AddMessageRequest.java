package org.demo.interfaces.entity.request;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class AddMessageRequest implements Serializable {
    private String content;
    private String user;

    public String getContent() {
        return content;
    }

    public String getUser() {
        return user;
    }

    public AddMessageRequest(String content, String user) {
        this.content = content;
        this.user = user;
    }
}
