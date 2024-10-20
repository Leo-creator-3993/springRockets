package com.future.spring.rocket.aop.extend.test3;

public class ServiceProxyImpl implements IServiceProxy{

    @Override
    public void keep(String msg) {
        System.out.println("keeping ==> " + msg);
    }
}
