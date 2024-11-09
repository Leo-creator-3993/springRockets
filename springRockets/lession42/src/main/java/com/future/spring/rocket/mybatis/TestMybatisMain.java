package com.future.spring.rocket.mybatis;

import com.future.spring.rocket.mybatis.model.UserModel;
import com.future.spring.rocket.mybatis.service.IUserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMybatisMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        IUserService userService = context.getBean("userServiceImpl", IUserService.class);
        UserModel userModel = UserModel.builder().name("leo").build();
        userService.truncate();
        userService.insert(userModel);
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        IUserService userService = context.getBean("userServiceImpl", IUserService.class);
        System.out.println(userService.findAll());
    }
}
