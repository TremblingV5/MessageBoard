package org.demo.interfaces.protocol;

import org.demo.interfaces.entity.request.AddMessageRequest;
import org.demo.interfaces.entity.request.ListMessageRequest;
import org.demo.interfaces.entity.response.AddMessageResponse;
import org.demo.interfaces.entity.response.ListMessageResponse;

public interface MessageServiceImpl {
    ListMessageResponse ListMessage(ListMessageRequest request);
    AddMessageResponse AddMessage(AddMessageRequest request);
}
