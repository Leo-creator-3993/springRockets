package com.future.spring.rocket;

import com.future.spring.rocket.common.util.OtherUtil;
import com.future.spring.rocket.impl.*;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        IProxyService iProxyService = new ServiceAImpl();
        IProxyService iProxyService2 = new ServiceBImpl();
        iProxyService.m1();
        iProxyService.m2();
        iProxyService2.m1();
        iProxyService2.m2();
        OtherUtil.splitLinePrint();

        ServiceProxy serviceProxy = new ServiceProxy(new ServiceAImpl());
        ServiceProxy serviceProxy2 = new ServiceProxy(new ServiceBImpl());
        serviceProxy.m1();
        serviceProxy.m2();
        serviceProxy2.m1();
        serviceProxy2.m2();
        OtherUtil.splitLinePrint();
        //jdk 实现动态代理
        //1.使用InvocationHandler接口创建代理类的处理器
        //2.使用Proxy类的静态方法newProxyInstance直接创建代理对象
        //3.使用代理对象
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("invocationHandler, method:" + method.getName());
                return null;
            }
        };
        IProxyService proxyService = (IProxyService) Proxy.newProxyInstance(IProxyService.class.getClassLoader(), new Class[]{IProxyService.class}, invocationHandler);
        proxyService.m1();
        proxyService.m2();
        OtherUtil.splitLinePrint();
        IProxyService ips = JdkCostTimeInvocationHandler.createProxyTarget(new ServiceAImpl(), IProxyService.class);
        ips.m1();
        ips.m2();

        IProxyService ips2 = JdkCostTimeInvocationHandler.createProxyTarget(new ServiceBImpl(), IProxyService.class);
        ips2.m1();
        ips2.m2();
        OtherUtil.splitLinePrint();
        IUserService iUserService = JdkCostTimeInvocationHandler.createProxyTarget(new UserServiceImpl(), IUserService.class);
        iUserService.insert("better and more");
        OtherUtil.splitLinePrint();
        //1.创建Enhancer对象
        //2.通过setSuperclass来设置父类型，即需要给哪个类创建代理类
        /*3.设置回调，需实现org.springframework.cglib.proxy.Callback接口，
        此处我们使用的是org.springframework.cglib.proxy.MethodInterceptor，也是一个接口，实现了Callback接口，
        当调用代理对象的任何方法的时候，都会被MethodInterceptor接口的invoke方法处理*/
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ServiceAImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("== debug , object:" + objects.getClass() + ", method:" + method.getName() + ", methodProxy:"+ methodProxy.getSuperName());
                long startTime = System.nanoTime();
                Object result = methodProxy.invokeSuper(o, objects);
                long endTime = System.nanoTime();
                System.out.println("调用 " + o.getClass() + "方法: " + method.getName() + " 耗时:" + (endTime - startTime) + " ns.");
                System.out.println("== method invoke result:" + result);
                return result;
            }
        });
        ServiceAImpl sa = (ServiceAImpl) enhancer.create();
        sa.m1();
        sa.m2();
        OtherUtil.splitLinePrint();
        ServiceAImpl saa = CGLibCostTimeInvocationHandler.createProxy(new ServiceAImpl());
        saa.m1();
        saa.m2();

        ServiceBImpl sab = CGLibCostTimeInvocationHandler.createProxy(new ServiceBImpl());
        sab.m1();
        sab.m2();


    }
}
