package com.dto.request;

import java.util.List;

public class PageResult<T> {
    private List<T> records;
    private int count;
    private Integer page;
    private Integer pageSize;

    public PageResult() {
    }

    public PageResult(List<T> records, Integer pageSize, Integer page, int count) {
        this.records = records;
        this.pageSize = pageSize;
        this.page = page;
        this.count = count;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
