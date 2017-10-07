package com.example.demo.mapper;

import com.example.demo.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import com.gulusoft.util.BaseMapper;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    public List<Category> getItemsByParentId(int id);

}
