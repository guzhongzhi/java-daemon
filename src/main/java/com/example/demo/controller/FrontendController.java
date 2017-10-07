package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/9/27.
 */
@Controller
public class FrontendController {
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected CategoryMapper categoryMapper;

    protected ModelAndView initViewModel() {
        System.out.println("Get Navigation");
        List<Category> categories = categoryMapper.getItemsByParentId(213);
        ModelAndView response = new ModelAndView();
        for(Category item : categories) {
            categoryMapper.update(item);
        }
        response.addObject("navigation",categories);
        System.out.println(request.getContextPath() + "DDDDDDDD");
        response.addObject("request",request);
        return response;
    }

}
