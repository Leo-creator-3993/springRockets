package com.future.spring.rocket.proxy.jdktest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MethodCostTimeInvokeHandler implements InvocationHandler {

    //被代理的对象
    private Object target;

    public MethodCostTimeInvokeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("执行代理... 调用方法 ==> %s%n", method.getName());
        long start = System.currentTimeMillis();
        Object result = method.invoke(this.target, args);
        System.out.printf("方法调用耗时:%s ms.%n", System.currentTimeMillis() - start);
        System.out.printf("入参输出 proxy ==> %s, method ==> %s, args ==> %s%n", proxy.getClass(), method, args);
        return result;
    }
}
