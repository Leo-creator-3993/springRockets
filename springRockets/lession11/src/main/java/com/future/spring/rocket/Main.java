package com.future.spring.rocket;

import com.future.spring.rocket.entity.PrototypeApplicationContextModel;
import com.future.spring.rocket.entity.PrototypeLookupMethodModel;
import com.future.spring.rocket.entity.PrototypeModel;
import com.future.spring.rocket.entity.PrototypeReplaceMethodModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        String beanPath = "classpath:beans-01.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanPath);
        PrototypeModel p1 = context.getBean(PrototypeModel.class);
        PrototypeModel p2 = context.getBean(PrototypeModel.class);
        System.out.println("p1:" + p1);
        System.out.println("p2:" + p2);

        System.out.println("==============================SplitLine==============================");
        PrototypeApplicationContextModel pa1 = context.getBean(PrototypeApplicationContextModel.class);
        pa1.talk();
        PrototypeApplicationContextModel pa2 = context.getBean(PrototypeApplicationContextModel.class);
        pa2.talk();

        System.out.println("==============================SplitLine==============================");
        PrototypeLookupMethodModel pl1 = context.getBean(PrototypeLookupMethodModel.class);
        PrototypeLookupMethodModel pl2 = context.getBean(PrototypeLookupMethodModel.class);
        pl1.talk();
        pl2.talk();
        System.out.println("==============================SplitLine==============================");
        PrototypeReplaceMethodModel pr1 = context.getBean(PrototypeReplaceMethodModel.class);
        PrototypeReplaceMethodModel pr2 = context.getBean(PrototypeReplaceMethodModel.class);
        pr1.talk();
        pr2.talk();


        context.close();
    }
}
