package com.future.spring.rocket;

import com.future.spring.rocket.entity.BeanCreateDestroyModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        String beanPath = "classpath:beans-01.xml";
        System.out.println("Spring 容器启动中...");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanPath);
        System.out.println("Spring 容器启动完成, 准备关闭容器...");

        BeanCreateDestroyModel beanCreateDestroyModel = context.getBean(BeanCreateDestroyModel.class);
        System.out.println(beanCreateDestroyModel);

        context.close();
        System.out.println("Spring 容器关闭完成");
    }
}