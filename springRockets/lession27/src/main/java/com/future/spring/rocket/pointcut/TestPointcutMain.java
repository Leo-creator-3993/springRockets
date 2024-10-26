package com.future.spring.rocket.pointcut;

import com.future.spring.rocket.common.util.OtherUtil;
import com.future.spring.rocket.pointcut.test1.Aspect1;
import com.future.spring.rocket.pointcut.test1.AspectBaseService1;
import com.future.spring.rocket.pointcut.test10.BaseService;
import com.future.spring.rocket.pointcut.test10.MainConfig10;
import com.future.spring.rocket.pointcut.test2.AJModelC2;
import com.future.spring.rocket.pointcut.test2.AspectJ2;
import com.future.spring.rocket.pointcut.test3.AspectJ3;
import com.future.spring.rocket.pointcut.test3.AspectJ3Impl;
import com.future.spring.rocket.pointcut.test3.IAspectJ3;
import com.future.spring.rocket.pointcut.test4.AspectJ4;
import com.future.spring.rocket.pointcut.test5.AspectJ5;
import com.future.spring.rocket.pointcut.test5.AspectJService5;
import com.future.spring.rocket.pointcut.test6.AspectJ6;
import com.future.spring.rocket.pointcut.test6.AspectJService6;
import com.future.spring.rocket.pointcut.test6_1.AspectJ6Son;
import com.future.spring.rocket.pointcut.test6_1.AspectJ6X;
import com.future.spring.rocket.pointcut.test7.AspectJ7;
import com.future.spring.rocket.pointcut.test8.AspectJ8;
import com.future.spring.rocket.pointcut.test8.AspectJ8Service;
import com.future.spring.rocket.pointcut.test9.AspectJ9;
import com.future.spring.rocket.pointcut.test9.AspectJ9Son;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.ClassUtils;

public class TestPointcutMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        try {
            AspectBaseService1 target = new AspectBaseService1();
            AspectJProxyFactory factory = new AspectJProxyFactory();
            factory.setTarget(target);
            factory.addAspect(Aspect1.class);

            AspectBaseService1 proxy = factory.getProxy();
            proxy.m1();
            proxy.m2();
        } catch (Exception e) {
            System.out.println(" 捕获异常 ==> " + e.getMessage());
        }
    }

    @Test
    public void test2() {
        AJModelC2 target = new AJModelC2();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(AspectJ2.class);

        AJModelC2 proxy = factory.getProxy();
        proxy.m1();
        proxy.m2();
        proxy.m3();
    }

    @Test
    public void test3() {
        AspectJ3Impl target = new AspectJ3Impl();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        Class<?>[] targetInterfaces = ClassUtils.getAllInterfaces(target);
        factory.setInterfaces(targetInterfaces);
        factory.addAspect(AspectJ3.class);
        factory.setProxyTargetClass(true); // 使用cglib动态代理

        Object proxy = factory.getProxy();
        assert proxy instanceof  IAspectJ3;
        ((IAspectJ3) proxy).m3();

        System.out.println("是否jdk 动态代理 ==> " + AopUtils.isJdkDynamicProxy(proxy));
        System.out.println("是否cglib 动态代理 ==> " + AopUtils.isCglibProxy(proxy));
        System.out.println(AspectJ3Impl.class.isAssignableFrom(proxy.getClass()));
    }

    @Test
    public void test4() {
        AspectJ3Impl target = new AspectJ3Impl();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(AspectJ4.class);

        AspectJ3Impl proxy = factory.getProxy();
        //cglib代理,继承方式,所以符合条件
        System.out.println(" ==> " + proxy.getClass());
        System.out.println(proxy instanceof AspectJ3Impl);
        proxy.m3();
    }

    @Test
    public void test5() {
        AspectJService5 target = new AspectJService5();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(AspectJ5.class);
        AspectJService5 proxy = factory.getProxy();
        proxy.m1(100.33);
        OtherUtil.splitLinePrint();
        proxy.m1(200);
    }

    @Test
    public void test6() {
        AspectJService6 target = new AspectJService6();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(AspectJ6.class);
        AspectJService6 proxy = factory.getProxy();
        proxy.m1();
    }

    @Test
    public void test6X() {
        AspectJ6Son target = new AspectJ6Son();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(AspectJ6X.class);
        AspectJ6Son proxy = factory.getProxy();
        proxy.m1();
        OtherUtil.splitLinePrint();
        proxy.m2();
        OtherUtil.splitLinePrint();
        proxy.m3();
    }

    @Test
    public void test7() {
        AspectJ6Son target = new AspectJ6Son();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(AspectJ7.class);
        AspectJ6Son proxy = factory.getProxy();
        proxy.m1();
        OtherUtil.splitLinePrint();
        proxy.m2();
        OtherUtil.splitLinePrint();
        proxy.m3();
    }

    @Test
    public void test8() {
        AspectJ8Service target = new AspectJ8Service();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(AspectJ8.class);
        AspectJ8Service proxy = factory.getProxy();
        proxy.m1(new AspectJ8Service.Car());
    }


    @Test
    public void test9() {
        AspectJ9Son target = new AspectJ9Son();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(AspectJ9.class);
        AspectJ9Son proxy = factory.getProxy();
        proxy.m1();
        proxy.m2();
        proxy.m3();
    }

    @Test
    public void test10() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig10.class);

        BaseService baseService1 = context.getBean("baseService1", BaseService.class);
        baseService1.m1();
        OtherUtil.splitLinePrint();

        BaseService baseService2 = context.getBean("baseService2", BaseService.class);
        baseService2.m1();
    }

}
