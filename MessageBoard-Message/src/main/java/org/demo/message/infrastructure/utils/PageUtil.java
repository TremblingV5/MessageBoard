package org.demo.message.infrastructure.utils;

import java.util.List;

public class PageUtil<T> {
    private int page;
    private int pageSize;
    private int totalPage;
    private int totalCount;
    public List<T> rows;

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageUtil(int page, int pageSize, int totalCount, List<T> rows) {
        if (page < 1) {
            page = 1;
        }

        if (pageSize < 1) {
            pageSize = 10;
        }

        setTotalPage(totalCount, pageSize);

        if (page > this.totalPage) {
            page = this.totalPage;
        }

        this.page = page;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.rows = rows;
    }

    public int getStart() {
        return (int) Math.ceil((page - 1) * pageSize);
    }

    public void setTotalPage(int totalCount,int pageSize) {
        this.totalPage = (int) Math.ceil(totalCount / pageSize);
    }
}
