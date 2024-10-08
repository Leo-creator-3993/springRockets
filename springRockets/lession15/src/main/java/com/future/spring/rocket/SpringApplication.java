package com.future.spring.rocket;

import com.future.spring.rocket.config.*;
import com.future.spring.rocket.service.IConfigService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class SpringApplication {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        Map<String,String> serviceMap = context.getBeansOfType(String.class);
        serviceMap.forEach((beanName, bean) -> {
            System.out.println(String.format("%s -> %s", beanName, bean));
        });
    }

    @org.junit.Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        Map<String,String> serviceMap = context.getBeansOfType(String.class);
        serviceMap.forEach((beanName, bean) -> {
            System.out.println(String.format("%s -> %s", beanName, bean));
        });
    }

    @org.junit.Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        Map<String,IConfigService> serviceMap = context.getBeansOfType(IConfigService.class);
        serviceMap.forEach((beanName, bean) -> {
            System.out.println(String.format("%s -> %s", beanName, bean));
        });
    }

    @org.junit.Test
    public void test4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EnvMainConfig.class);
        Map<String,String> serviceMap = context.getBeansOfType(String.class);
        serviceMap.forEach((beanName, bean) -> {
            System.out.println(String.format("%s -> %s", beanName, bean));
        });
    }

    @Test
    public void test5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig4.class);
    }

    @org.junit.Test
    public void test6() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig6.class);
        Map<String,String> serviceMap = context.getBeansOfType(String.class);
        serviceMap.forEach((beanName, bean) -> {
            System.out.println(String.format("%s -> %s", beanName, bean));
        });
    }
}
