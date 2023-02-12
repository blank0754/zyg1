package com.example.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 分页的结果参数
 * */

@EqualsAndHashCode(callSuper = true)
@Data
public class PageResult<T>  extends Result implements Serializable {
    private long total;//总记录数

    private List<T> rows;//分页的数据

    public PageResult(long total, List<T> list) {
        this.setSuccess(true);
        this.setMessage("分页查询成功");
        this.total = total;
        this.rows = list;
    }

    /**
     * 直接返回分页数据
     * 
     * */
    public static Result pageResult(long total, List list) {
        PageResult pageResult = new PageResult(total, list);
        return pageResult;
    }
}
