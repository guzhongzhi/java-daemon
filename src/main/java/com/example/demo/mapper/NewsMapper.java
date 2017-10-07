package com.example.demo.mapper;

import com.example.demo.entity.News;
import com.gulusoft.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Mapper
public interface NewsMapper extends BaseMapper<News> {

}
