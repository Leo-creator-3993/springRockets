package com.future.spring.rocket.parent;

import com.future.spring.rocket.parent.entity.DupMainConfig1;
import com.future.spring.rocket.parent.entity.DupService2;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DupMainConfig1.class);
        //context.refresh();

        DupService2 dupService2 = context.getBean(DupService2.class);
        dupService2.m2();
    }
}
