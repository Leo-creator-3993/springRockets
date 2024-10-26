package com.future.spring.rocket.aop.type;

import com.future.spring.rocket.aop.type.Model.ProxyFactoryBeanModel;
import com.future.spring.rocket.aop.type.test1.MainConfig1;
import com.future.spring.rocket.aop.type.test2.MainConfig2;
import com.future.spring.rocket.aop.type.test3.MainConfig3;
import com.future.spring.rocket.common.util.OtherUtil;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestProxyFactoryBeanMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        ProxyFactoryBean proxyFactoryBean = context.getBean(ProxyFactoryBean.class);
        Object target = proxyFactoryBean.getObject();
        assert target instanceof ProxyFactoryBeanModel;
        ProxyFactoryBeanModel p = (ProxyFactoryBeanModel) target;
        p.m1();
        OtherUtil.splitLinePrint();
        String result = p.m2("foo");
        System.out.println("==> " + result);
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        ProxyFactoryBeanModel p = context.getBean("proxyFactoryBean", ProxyFactoryBeanModel.class);
        p.m1();
        OtherUtil.splitLinePrint();
        String result = p.m2("foo");
        System.out.println("==> " + result);
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        ProxyFactoryBean proxyFactoryBean = context.getBean(ProxyFactoryBean.class);
        Object target = proxyFactoryBean.getObject();
        assert target instanceof ProxyFactoryBeanModel;
        ProxyFactoryBeanModel p = (ProxyFactoryBeanModel) target;
        p.m1();
        OtherUtil.splitLinePrint();
        String result = p.m2("foo");
        System.out.println("==> " + result);
    }

}
