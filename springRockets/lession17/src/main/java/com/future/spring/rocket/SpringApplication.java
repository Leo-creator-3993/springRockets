package com.future.spring.rocket;

import com.future.spring.rocket.test1.MainConfig1;
import com.future.spring.rocket.test1.ScopePrototypeModel;
import com.future.spring.rocket.test1.ScopeSingletonModel;
import com.future.spring.rocket.test2.DependOnServiceB;
import com.future.spring.rocket.test2.MainConfig2;
import com.future.spring.rocket.test3.MainConfig3;
import com.future.spring.rocket.test4.MainConfig4;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        System.out.println(context.getBean(ScopeSingletonModel.class));
        System.out.println(context.getBean(ScopeSingletonModel.class));

        System.out.println(context.getBean(ScopePrototypeModel.class));
        System.out.println(context.getBean(ScopePrototypeModel.class));

        System.out.println(context.getBean("singleton"));
        System.out.println(context.getBean("singleton"));

        System.out.println(context.getBean("sPrototype"));
        System.out.println(context.getBean("sPrototype"));
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println(context.getBean(DependOnServiceB.class));
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        System.out.println(context.getBean("importResourceServiceA"));
    }

    @Test
    public void test4() {
        System.out.println("开始启动Spring...");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig4.class);
        System.out.println("启动Spring完成!");
        for(String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s -> %s", beanName, context.getBean(beanName)));
        }
    }
}
