package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.mapper.entity.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageHelper;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27.
 */
@Controller
public class IndexController extends FrontendController {
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/")
    public ModelAndView  index() {
        ModelAndView response = this.initViewModel();

        com.example.demo.util.PageHelper pageHelper = new com.example.demo.util.PageHelper();
        pageHelper.setPage(5);
        pageHelper.setMapper(categoryMapper);
        List<Category> categories = categoryMapper.getPageList(pageHelper);

        response.addObject("listItems",categories);
        response.addObject("itemCount",pageHelper.getPageCount() + "/" + pageHelper.getCount());
        response.addObject("name","test");
        response.setViewName("index");
        return response;
    }


}
