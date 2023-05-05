package org.demo.interfaces.entity.request;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class ListMessageRequest implements Serializable {
    private int page;

    public int getPage() {
        return page;
    }

    public ListMessageRequest(int page) {
        this.page = page;
    }
}
