package com.future.spring.rocket.aop.type.test2;

import com.future.spring.rocket.aop.type.Model.ProxyFactoryBeanModel;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
public class MainConfig2 {

    @Bean
    public ProxyFactoryBeanModel proxyFactoryBeanModel() {
        return new ProxyFactoryBeanModel();
    }

    @Bean
    public Advisor interceptor1() {
        //批量方式需要包装成Advisor
        MethodBeforeAdvice methodBeforeAdvice =  new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("正在前置调用方法 ==> " + method.getName());
            }
        };

        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setAdvice(methodBeforeAdvice);
        return defaultPointcutAdvisor;
    }

    @Bean
    public MethodInterceptor interceptor2() {
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
        proxyFactoryBean.setInterceptorNames("interceptor*");
        return proxyFactoryBean;
    }
}
