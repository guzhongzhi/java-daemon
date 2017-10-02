package com.example.demo.config;

import cn.org.rapid_framework.freemarker.directive.BlockDirective;
import cn.org.rapid_framework.freemarker.directive.ExtendsDirective;
import cn.org.rapid_framework.freemarker.directive.OverrideDirective;
import cn.org.rapid_framework.freemarker.directive.SuperDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2017/9/27.
 */
@Configuration
@EnableAutoConfiguration
public class FreemarkerConfig {

    @Autowired
    freemarker.template.Configuration configuration;

    @PostConstruct
    public void setSharedVariable(){
        configuration.setSharedVariable("block", new BlockDirective());
        configuration.setSharedVariable("override", new OverrideDirective());
        configuration.setSharedVariable("extends", new ExtendsDirective());
        configuration.setSharedVariable("super", new SuperDirective());
    }
}
