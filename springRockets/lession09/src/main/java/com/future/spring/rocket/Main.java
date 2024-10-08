package com.future.spring.rocket;

import com.future.spring.rocket.entity.LazyInitBeanModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        String beanPath = "classpath:beans-01.xml";
        System.out.println("开始启动Spring Bean容器...");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanPath);
        System.out.println("Spring容器启动完毕!");
        System.out.println("========================开始获取Bean========================");
        LazyInitBeanModel lazyInitBeanModel = context.getBean(LazyInitBeanModel.class);
        System.out.println(lazyInitBeanModel);
    }
}