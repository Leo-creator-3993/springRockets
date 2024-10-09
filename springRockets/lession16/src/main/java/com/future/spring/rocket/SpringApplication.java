package com.future.spring.rocket;

import com.future.spring.rocket.test1.MainConfig1;
import com.future.spring.rocket.test2.MainConfig2;
import com.future.spring.rocket.test3.MainConfig3;
import com.future.spring.rocket.test4.MainConfig4;
import com.future.spring.rocket.test5.MainConfig5;
import com.future.spring.rocket.test6.MainConfig6;
import com.future.spring.rocket.test7.MainConfig7;
import com.future.spring.rocket.test8.MainConfig8;
import com.future.spring.rocket.test8.service.OrderService;
import com.future.spring.rocket.test8.service.UserService;
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
        for( String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s -> %s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        for( String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s -> %s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        for( String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s -> %s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig4.class);
        for( String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s -> %s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig5.class);
        for( String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s -> %s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test6() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig6.class);
        for( String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s -> %s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test7() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig7.class);
        for( String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s -> %s", beanName, context.getBean(beanName)));
        }
    }

    @Test
    public void test8() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig8.class);
        System.out.println(context.getBean(UserService.class).getDao());
        System.out.println(context.getBean(OrderService.class).getDao());
    }
}
