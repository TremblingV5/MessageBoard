package org.demo.protocol;

import org.demo.entity.pojo.Message;
import org.demo.entity.request.AddMessageRequest;
import org.demo.entity.request.ListMessageRequest;
import org.demo.entity.response.AddMessageResponse;
import org.demo.entity.response.ListMessageResponse;

import java.util.List;

public interface MessageServiceImpl {
    ListMessageResponse ListMessage(ListMessageRequest request);
    AddMessageResponse AddMessage(AddMessageRequest request);
}
