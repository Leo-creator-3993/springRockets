package com.future.spring.custom.event.listener;

import com.future.spring.custom.event.listener.config.MainConfig;
import com.future.spring.custom.event.listener.instance.UserRegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        UserRegisterService userRegisterService = context.getBean(UserRegisterService.class);
        userRegisterService.registerUser("John");
    }
}
