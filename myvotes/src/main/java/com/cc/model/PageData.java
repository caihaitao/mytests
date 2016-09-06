package com.cc.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public class PageData<T> implements Serializable {
    //jquery easyui 对应这两个属性名，更改后可能导致datagrid中数据显示不出来
    private List<T> rows;
    private Long total;

    public PageData(List<T> datas) {
        this.rows = datas;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
