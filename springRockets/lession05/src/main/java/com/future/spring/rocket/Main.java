package com.future.spring.rocket;

import com.future.spring.rocket.entity.DiAutowireConstructorModel;
import com.future.spring.rocket.entity.DiAutowireModel;
import com.future.spring.rocket.entity.DiAutowireModelExtend;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        String beanPath = "classpath:/beans-01.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanPath);
        DiAutowireModel diAutowireModel = (DiAutowireModel) context.getBean("diAutowireM1");
        System.out.println(diAutowireModel);

        System.out.println("----------------------------------------------------------------------");
        DiAutowireModel diAutowireM2 = (DiAutowireModel) context.getBean("diAutowireM2");
        System.out.println(diAutowireM2);

        System.out.println("----------------------------------------------------------------------");
        DiAutowireModel diAutowireM3 = (DiAutowireModel) context.getBean("diAutowireM3");
        System.out.println(diAutowireM3);

        System.out.println("----------------------------------------------------------------------");
        DiAutowireConstructorModel autowireConstructorModel = (DiAutowireConstructorModel) context.getBean("diAutowireConstructor");
        System.out.println(autowireConstructorModel);

        System.out.println("----------------------------------------------------------------------");
        DiAutowireModelExtend diAutowireModelExtend = (DiAutowireModelExtend) context.getBean("diAutowireExtend");
        System.out.println(diAutowireModelExtend);
    }


}