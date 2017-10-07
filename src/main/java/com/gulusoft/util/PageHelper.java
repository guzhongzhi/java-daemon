package com.gulusoft.util;

import com.gulusoft.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/9/27.
 */
public class PageHelper {

    @Autowired
    BaseMapper mapper;

    protected int offset = 0, pageSize = 20,page = 1, itemCount = -1;
    protected String where = "",orderBy = "";

    public PageHelper setMapper(BaseMapper mapper) {
        this.mapper = mapper;
        return this;
    }

    public PageHelper setPage(int page) {
        this.page = page;
        return this;
    }

    public int getCount() {
        if(itemCount == -1) {
            itemCount = mapper.getItemCount(this);
        }
        return itemCount;
    }

    public int getPageCount() {
        return (int)Math.ceil( (double)getCount() / getPageSize());
    }

    public PageHelper setWhere(String where) {
        this.where = where;
        return this;
    }

    public String getWhere() {
        if(where != "") {
            return " AND " + where;
        }
        return where;
    }

    public PageHelper addFilter(String fieldName, String operation, String value) {
        value = value.replace("'","");
        this.where  =   this.where  + (this.where == "" ? "" : " AND ") + fieldName + " " + operation + " " + value;
        return this;
    }

    public int getOffset() {
        return (page - 1) * pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public String getLimit() {
        return getOffset() + "," + getPageSize();
    }

    public String getOrderBy() {
        if(orderBy.length() > 0) {
            return "ORDER BY " + orderBy;
        }
        return "";
    }
}
