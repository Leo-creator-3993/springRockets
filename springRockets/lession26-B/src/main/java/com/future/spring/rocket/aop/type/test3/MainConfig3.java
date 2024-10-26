package com.future.spring.rocket.aop.type.test3;

import com.future.spring.rocket.aop.type.Model.ProxyFactoryBeanModel;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
public class MainConfig3 {

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
    public AfterReturningAdvice afterReturningAdvice() {
        return new AfterReturningAdvice(){
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] objects, Object target) throws Throwable {
                System.out.println(String.format("正在调用后置 ==> returnValue:%s, method:%s, objects:%s, target:%s", returnValue, method, Arrays.asList(objects), target));
            }
        };
    }

    @Bean
    public ProxyFactoryBean proxyFactoryBean() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTargetName("proxyFactoryBeanModel");
        proxyFactoryBean.setInterceptorNames("methodBeforeAdvice", "methodInterceptor", "afterReturningAdvice");
        return proxyFactoryBean;
    }
}
