package com.sein.pojo.dto;

import java.util.List;

/**
 * Created by ldb on 2017/7/15.
 * layui的列表返回类
 */
public class PageResult<T> {

    private long total;
    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
