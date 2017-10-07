package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.News;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.util.PageHelper;
import java.util.List;

/**
 * Created by Administrator on 2017/9/27.
 */
@Controller
public class IndexController extends FrontendController {
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    NewsMapper newsMapper;

    @RequestMapping("/news/detail-{id}.do")
    public ModelAndView newsDetail(@PathVariable("id") String id) {
        ModelAndView response = this.initViewModel();
        News news = newsMapper.load(Integer.parseInt(id));
        response.addObject("news",news);
        response.setViewName("newsDetail");
        return response;
    }

    @RequestMapping("/category/{id}.do")
    public ModelAndView categoryList(@PathVariable("id") String id) {
        ModelAndView response = this.initViewModel();

        PageHelper  pageHelper = new PageHelper();
        pageHelper.addFilter("category_id","=",id);

        pageHelper.setMapper(newsMapper);
        List<News> news = newsMapper.getPageList(pageHelper);

        response.addObject("listItems",news);

        response.addObject("itemCount",pageHelper.getPageCount() + "/" + pageHelper.getCount());
        response.addObject("name","test");
        response.setViewName("index");
        return response;
    }

    @RequestMapping("/")
    public ModelAndView  index() {
        System.out.println("EEEEEEEEEEEEEEEEEEE");
        ModelAndView response = this.initViewModel();

        com.example.demo.util.PageHelper pageHelper = new com.example.demo.util.PageHelper();
        pageHelper.setMapper(categoryMapper);
        List<Category> categories = categoryMapper.getPageList(pageHelper);
        for(Category category : categories) {
            category.setNewsMapper(newsMapper);
        }
        response.addObject("listItems",categories);
        response.addObject("itemCount",pageHelper.getPageCount() + "/" + pageHelper.getCount());
        response.addObject("name","test");
        response.setViewName("index");
        return response;
    }
}
