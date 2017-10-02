package com.example.demo.mapper.entity;

import com.example.demo.entity.Category;
import com.example.demo.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27.
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    public List<Category> getItemsByParentId(int id);

}
