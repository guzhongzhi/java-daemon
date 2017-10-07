package com.example.demo.entity;

import com.example.demo.mapper.NewsMapper;
import com.gulusoft.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.News;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

public class Category extends AbstractEntity {

    @Autowired
    NewsMapper newsMapper;

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
        return "/category/" + this.getId() + getUrlSubfix();
    }

    public void setNewsMapper(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    public List<News> getTopNews() {
        PageHelper pageHelper = new PageHelper();
        pageHelper.addFilter("category_id","=",String.valueOf(getId()));
        pageHelper.setMapper(newsMapper);
        return newsMapper.getPageList(pageHelper);
    }
}
