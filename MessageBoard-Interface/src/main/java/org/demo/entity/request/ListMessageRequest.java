package org.demo.entity.request;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class ListMessageRequest implements Serializable {
    private Integer page;

    public Integer getPage() {
        return page;
    }

    public ListMessageRequest(Integer page) {
        this.page = page;
    }
}
