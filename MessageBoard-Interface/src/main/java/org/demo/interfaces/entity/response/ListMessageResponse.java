package org.demo.interfaces.entity.response;

import lombok.Builder;
import org.demo.interfaces.entity.pojo.Message;

import java.io.Serializable;
import java.util.List;

@Builder
public class ListMessageResponse extends Base implements Serializable {
    private List<Message> messageList;

    public List<Message> getMessageList() {
        return messageList;
    }

    public ListMessageResponse(List<Message> messageList) {
        this.messageList = messageList;
    }
}
