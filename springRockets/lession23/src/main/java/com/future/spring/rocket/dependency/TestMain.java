package com.future.spring.rocket.dependency;

import com.future.spring.rocket.common.util.OtherUtil;
import com.future.spring.rocket.dependency.test1.MainConfig1;
import com.future.spring.rocket.dependency.test1.ServiceA;
import com.future.spring.rocket.dependency.test2.MainConfig2;
import com.future.spring.rocket.dependency.test2.ServiceC;
import com.future.spring.rocket.dependency.test2.ServiceD;
import com.future.spring.rocket.dependency.test3.MainConfig3;
import com.future.spring.rocket.dependency.test3.ServiceM1;
import com.future.spring.rocket.dependency.test3.ServiceM2;
import com.future.spring.rocket.dependency.test4.MainConfig4;
import com.future.spring.rocket.dependency.test4.ServiceK1;
import com.future.spring.rocket.dependency.test4.ServiceK2;
import com.future.spring.rocket.dependency.test5.MainConfig5;
import com.future.spring.rocket.dependency.test5.ServiceR1;
import com.future.spring.rocket.dependency.test5.ServiceR2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void testDependencyException() {
        //构造器方式无法解决单例下的循环依赖
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        ServiceA serviceA = context.getBean(ServiceA.class);
        System.out.println(serviceA);
    }

    @Test
    public void test1() {
        //单例情况下,通过setter方式注入,spring通过三级缓存解决了循环依赖
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        ServiceC serviceC = context.getBean(ServiceC.class);
        ServiceD serviceD = context.getBean(ServiceD.class);
        System.out.println(serviceC);
        System.out.println(serviceD);
    }


    @Test
    public void testProtoTypeException() {
        //多例情况下,即使是通过setter方式注入,也无法解决循环依赖的问题
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        ServiceM1 serviceM1 = context.getBean(ServiceM1.class);
        ServiceM2 serviceM2 = context.getBean(ServiceM2.class);
        System.out.println(serviceM1);
        System.out.println(serviceM2);
    }

    @Test
    public void test4() {
        // 一个单例和一个多例的情况
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig4.class);
        ServiceK1 serviceK1 = context.getBean(ServiceK1.class);
        System.out.println(serviceK1);

        ServiceK2 serviceK2 = context.getBean(ServiceK2.class);
        System.out.println(serviceK2);
    }

    @Test
    public void testBeanDifferenceException() {
        //三级缓存可以发现早期bean和最终bean是否一致的问题,MethodBeforeInterceptor实现对bean的包装
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig5.class);
        ServiceR1 serviceR1 = context.getBean(ServiceR1.class);
        serviceR1.m1();
        OtherUtil.splitLinePrint();

        ServiceR2 serviceR2 = context.getBean(ServiceR2.class);
        serviceR2.m2();
    }

    @Test
    public void test5_1() {
        //使用MethodBeforeInterceptor测试,早期bean和最终bean不一致,通过设置允许,默认是不允许
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.addBeanFactoryPostProcessor(
                beanFactory -> {
                    if (beanFactory instanceof DefaultListableBeanFactory) {
                        //将allowRawInjectionDespiteWrapping设置为true(允许早期bean和最终bean不一致)
                        ((DefaultListableBeanFactory) beanFactory).setAllowRawInjectionDespiteWrapping(true);
                    }
                }
        );

        context.register(MainConfig5.class);
        context.refresh();

        ServiceR1 serviceR1 = context.getBean(ServiceR1.class);
        serviceR1.m1();
        OtherUtil.splitLinePrint();

        ServiceR2 serviceR2 = context.getBean(ServiceR2.class);
        serviceR2.m2();
        OtherUtil.splitLinePrint();
        System.out.println(serviceR1 == serviceR2.getServiceR1());
    }

    @Test
    public void test5_2() {
        //使用MethodBeforeInterceptor2测试,通过干预使早期bean和最终bean一致,都变成代理
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig5.class);
        context.refresh();

        ServiceR1 serviceR1 = context.getBean(ServiceR1.class);
        serviceR1.m1();
        OtherUtil.splitLinePrint();

        ServiceR2 serviceR2 = context.getBean(ServiceR2.class);
        serviceR2.m2();
        OtherUtil.splitLinePrint();
        System.out.println(serviceR1 == serviceR2.getServiceR1());
    }
}
