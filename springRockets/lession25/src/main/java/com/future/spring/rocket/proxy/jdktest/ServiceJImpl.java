package com.future.spring.rocket.proxy.jdktest;

public class ServiceJImpl implements IServiceJ1, IServiceJ2{

    @Override
    public void j1() {
        System.out.println("Invoke j1()");
    }

    @Override
    public void j2() {
        System.out.println("Invoke j2()");
    }
}
