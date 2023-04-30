package org.demo.entity.request;

import java.io.Serializable;

public class ListMessageRequest implements Serializable {
    private Integer page;

    public Integer getPage() {
        return page;
    }

    public ListMessageRequest(Integer page) {
        this.page = page;
    }
}
