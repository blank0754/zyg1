package com.example.util;

import lombok.Data;

import javax.validation.constraints.NotNull;

//统一的分页查询
@Data
public class QueryInfo {
    @NotNull
    private Integer pageNumber;//第几页
    @NotNull
    private Integer pageSize;//一页多少条数据

    private String token;//token

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
