package com.future.spring.rocket.aop.extend;

import com.future.spring.rocket.aop.extend.model.FoundService;
import com.future.spring.rocket.aop.extend.test3.IServiceProxy;
import com.future.spring.rocket.aop.extend.test3.ServiceProxyImpl;
import com.future.spring.rocket.aop.extend.test5.ServiceExtend;
import com.future.spring.rocket.common.util.OtherUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.jupiter.api.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestAopExtendMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        FoundService foundService = new FoundService();
        foundService.setName("Leo");
        ProxyFactory proxyFactory = new ProxyFactory(foundService);
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                if(objects.length > 0) {
                    String userName = (String) objects[0];
                    if (!"Leo".equals(userName)) {
                        throw new RuntimeException("用户 ==> " + userName + "==>" + method.getName() + " 非法访问!");
                    }
                }
            }
        });

        FoundService proxy = (FoundService) proxyFactory.getProxy();
        try {
            proxy.deposit("Mark", 1000);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            proxy.withdrawal("Mark", 100);
        }catch (Exception e) {
            //test...
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("用户余额 ==>" + proxy.getBalance("Mark"));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        OtherUtil.splitLinePrint();
        proxy.deposit("Leo", 1000);
        proxy.withdrawal("Leo", 100);
        System.out.println("用户余额 ==>" + proxy.getBalance("Leo"));
    }

    @Test
    public void test2() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new FoundService());
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println(String.format("method ==> %s, object ==> %s, objects ==> %s",
                        method, o, objects));
            }
        });

        Object proxy = proxyFactory.getProxy();
        System.out.println("代理对象的类型 ==> "+ proxy.getClass());
        System.out.println("代理对象的父类 ==> "+ proxy.getClass().getSuperclass());
        System.out.println("代理对象实现的接口列表:");
        for(Class<?> cf : proxy.getClass().getInterfaces()) {
            System.out.println(cf);
        }
    }

    @Test
    public void test3() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new ServiceProxyImpl());
        proxyFactory.setInterfaces(IServiceProxy.class);

        proxyFactory.setProxyTargetClass(true);//强制使用cglib代理
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("==> 开始调用前置方法...");
                System.out.println(String.format("method ==> %s, object ==> %s, objects ==> %s",
                        method, o, Arrays.asList(objects)));
            }
        });

        Object proxy = proxyFactory.getProxy();
        System.out.println("代理对象的类型 ==> "+ proxy.getClass());
        System.out.println("代理对象的父类 ==> "+ proxy.getClass().getSuperclass());
        System.out.println("代理对象实现的接口列表:");
        for(Class<?> cf : proxy.getClass().getInterfaces()) {
            System.out.println(cf);
        }

        //jdk代理
//        if(proxy instanceof IServiceProxy) {
//            IServiceProxy o = (IServiceProxy)proxy;
//            o.keep("calm...");
//        }

        //cglib代理
        if(proxy instanceof ServiceProxyImpl) {
            ServiceProxyImpl o = (ServiceProxyImpl)proxy;
            o.keep("calm...");
        }
    }

    @Test
    public void test5() {
        ServiceExtend target = new ServiceExtend();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.setExposeProxy(true);
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                String methodName = methodInvocation.getMethod().getName();
                System.out.println("开始调用方法 ==>" + methodName);
                long startTime = System.nanoTime();
                Object object = methodInvocation.proceed();
                System.out.println("调用结束," + methodName +  "耗时 ==>" + (System.nanoTime() - startTime) + " ns.");
                return object;
            }
        });

        ServiceExtend proxy = (ServiceExtend) proxyFactory.getProxy();
        proxy.m1();
    }
}
