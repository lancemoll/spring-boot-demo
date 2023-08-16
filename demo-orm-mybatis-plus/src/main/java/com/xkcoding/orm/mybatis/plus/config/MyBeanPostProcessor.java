package com.xkcoding.orm.mybatis.plus.config;

import com.xkcoding.orm.mybatis.plus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Slf4j
//@Component
//public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//    @Autowired
//    private UserService userService;
//
//    @PostConstruct
//    public void init() {
//        System.out.println(userService.getClass());
//    }
//
//    @Override
//    public int getOrder() {
//        return Ordered.HIGHEST_PRECEDENCE;
//    }
//}
