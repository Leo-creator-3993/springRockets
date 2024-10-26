package com.future.spring.rocket.aop.type.test1;

import com.future.spring.rocket.aop.type.Model.ProxyFactoryBeanModel;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
public class MainConfig1 {

    @Bean
    public ProxyFactoryBeanModel proxyFactoryBeanModel() {
        return new ProxyFactoryBeanModel();
    }

    @Bean
    public MethodBeforeAdvice methodBeforeAdvice() {
        return  new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("正在前置调用方法 ==> " + method.getName());
            }
        };
    }

    @Bean
    public MethodInterceptor methodInterceptor() {
        return new MethodInterceptor() {

            @Override
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                System.out.println("开始调用方法 ==> " + methodInvocation.getMethod().getName());
                long startTime = System.nanoTime();
                Object result = methodInvocation.proceed();
                System.out.println("调用方法 ==> " +  methodInvocation.getMethod().getName() + ", 耗时 ==> " + (System.nanoTime() - startTime) + " ns.");
                return result;
            }
        };
    }

    @Bean
    public ProxyFactoryBean proxyFactoryBean() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTargetName("proxyFactoryBeanModel");
        proxyFactoryBean.setInterceptorNames("methodBeforeAdvice", "methodInterceptor");
        return proxyFactoryBean;
    }

}
