package com.future.spring.rocket;

import com.future.spring.rocket.entity.ExtendServiceBModel;
import com.future.spring.rocket.entity.ExtendServiceCModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        String beanPath = "classpath:beans-01.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanPath);
        ExtendServiceBModel extendServiceBModel = context.getBean(ExtendServiceBModel.class);
        System.out.println(extendServiceBModel);
        ExtendServiceCModel extendServiceCModel = context.getBean(ExtendServiceCModel.class);
        System.out.println(extendServiceCModel);

        System.out.println("==============================SplitLine==============================");
        beanPath = "classpath:beans-02.xml";
        context.setConfigLocation(beanPath);
        context.refresh();
        extendServiceBModel = context.getBean(ExtendServiceBModel.class);
        System.out.println(extendServiceBModel);
        extendServiceCModel = context.getBean(ExtendServiceCModel.class);
        System.out.println(extendServiceCModel);

        context.close();
    }
}
