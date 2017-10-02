package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.mapper.entity.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27.
 */
@Controller
public class FrontendController {

    @Autowired
    protected CategoryMapper categoryMapper;
    protected ModelAndView initViewModel() {
        List<Category> categories = categoryMapper.getItemsByParentId(213);
        ModelAndView response = new ModelAndView();
        for(Category item : categories) {
            categoryMapper.update(item);
        }
        response.addObject("navigation",categories);
        return response;
    }

}
