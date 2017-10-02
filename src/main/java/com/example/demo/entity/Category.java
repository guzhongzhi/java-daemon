package com.example.demo.entity;

/**
 * Created by Administrator on 2017/9/27.
 */
public class Category {
    protected int id,status,parentId;
    protected String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parent_id) {
        this.parentId = parent_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return this.getId() + ".html";
    }
}
