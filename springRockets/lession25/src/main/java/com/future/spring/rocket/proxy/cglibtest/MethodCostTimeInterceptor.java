package com.future.spring.rocket.proxy.cglibtest;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodCostTimeInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(String.format("入参 object ==> %s, method ==> %s, objects ==> %s, methodProxy ==> %s",
                o.getClass(), method.getClass(), Arrays.asList(objects), methodProxy.getClass()));
        long startTime = System.nanoTime();
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(String.format("Invoke method:%s result ==> %s costTime:%s ms.", method.getName(), result, System.nanoTime() - startTime));
        return result;
    }
}
