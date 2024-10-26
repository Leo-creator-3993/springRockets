package com.future.spring.rocket.autoaspectj;

import com.future.spring.rocket.autoaspectj.test1.AutoAspectJService1;
import com.future.spring.rocket.autoaspectj.test1.MainConfig1;
import com.future.spring.rocket.autoaspectj.test2.AutoAspectJService2;
import com.future.spring.rocket.autoaspectj.test2.MainConfig2;
import com.future.spring.rocket.autoaspectj.test3.AutoAspectJService3;
import com.future.spring.rocket.autoaspectj.test3.MainConfig3;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAutoAspectJMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();

        AutoAspectJService1 service1 = context.getBean(AutoAspectJService1.class);
        service1.m1();
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        AutoAspectJService2 service2 = context.getBean(AutoAspectJService2.class);
        service2.m2();
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        AutoAspectJService3 service3 = context.getBean(AutoAspectJService3.class);
        service3.m3();
    }
}
