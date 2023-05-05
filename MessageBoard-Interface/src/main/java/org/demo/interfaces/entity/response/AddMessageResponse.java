package org.demo.interfaces.entity.response;

import lombok.Builder;
import org.demo.interfaces.entity.pojo.Message;

import java.io.Serializable;

@Builder
public class AddMessageResponse extends Base implements Serializable {
    private Message message;

    public Message getMessage() {
        return message;
    }

    public AddMessageResponse(Message message) {
        this.message = message;
    }
}
