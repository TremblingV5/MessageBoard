package org.demo.entity.response;

import org.demo.entity.pojo.Message;

import java.io.Serializable;

public class AddMessageResponse extends Base implements Serializable {
    private Message message;

    public Message getMessage() {
        return message;
    }

    public AddMessageResponse(Message message) {
        this.message = message;
    }
}
