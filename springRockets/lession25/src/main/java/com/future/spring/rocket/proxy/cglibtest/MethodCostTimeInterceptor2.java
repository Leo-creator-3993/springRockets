package com.future.spring.rocket.proxy.cglibtest;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodCostTimeInterceptor2 implements MethodInterceptor {
    private Object target;

    public MethodCostTimeInterceptor2(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(String.format("入参 object ==> %s, method ==> %s, objects ==> %s, methodProxy ==> %s",
                o.getClass(), method.getClass(), Arrays.asList(objects), methodProxy.getClass()));
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(target, objects);
        System.out.println(String.format("Invoke method:%s result ==> %s costTime:%s ms.", method.getName(), result, System.currentTimeMillis() - startTime));
        return result;
    }
}
