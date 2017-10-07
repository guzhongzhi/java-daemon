package com.example.demo.entity;

public class AbstractEntity {
    protected String urlSubfix = ".do";
    protected String tableName = "";
    protected String tablePrefix = "";

    public String getUrlSubfix() {
        return urlSubfix;
    }

    public String getTableName() {
        return tablePrefix + tableName;
    }
}
