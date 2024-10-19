package com.future.spring.rocket.dependency.test5;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

// test5_1 打开,测试时与MethodBeforeInterceptor2二选一
//@Component
public class MethodBeforeInterceptor implements BeanPostProcessor {

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("serviceR1".equals(beanName)) {
            //代理创建工厂，需传入被代理的目标对象
            ProxyFactory proxyFactory = new ProxyFactory(bean);
            //添加一个方法前置通知，会在方法执行之前调用通知中的before方法
            proxyFactory.addAdvice(new MethodBeforeAdvice() {
                @Override
                public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
                    System.out.println("你好,serviceR1");
                }
            });
            //返回代理对象
            return proxyFactory.getProxy();
        }
        return bean;
    }
}
