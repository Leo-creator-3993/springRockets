package com.future.spring.rocket.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkCostTimeInvocationHandler implements InvocationHandler {

    //被代理对象
    private Object target;

    public JdkCostTimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("==Debug proxy: " + proxy.getClass() + " , target: " + this.target.getClass());
        long startTime = System.nanoTime();
        Object result = method.invoke(this.target, args);
        long endTime = System.nanoTime();
        System.out.println("调用 " + this.target.getClass() + "方法: " + method.getName() + " 耗时:" + (endTime - startTime) + " ns.");
        return result;
    }

    public static <T> T  createProxyTarget(Object target, Class<T> targetInterface) {
        if(!targetInterface.isInterface()) {
            throw new IllegalStateException(targetInterface + " 必须是接口类型!");
        } else if (!targetInterface.isAssignableFrom(target.getClass())) {
            throw new IllegalStateException("target 必须是 targetInterface 的实现类");
        }
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class<?>[]{targetInterface}, new JdkCostTimeInvocationHandler(target));
    }
}
