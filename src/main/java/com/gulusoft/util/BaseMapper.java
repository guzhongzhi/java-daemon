package com.gulusoft.util;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27.
 */
@Mapper
public interface BaseMapper<T> {
    public T load(int id);
    public List<T> all();
    public int delete(int id);
    public int insert(T object);
    public void update(T object);
    public List<T> getPageList(PageHelper pageHelper);
    public int getItemCount(PageHelper pageHelper);
}
