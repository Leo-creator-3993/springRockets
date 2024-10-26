package com.future.spring.rocket.aop.type.Model;

public class ProxyFactoryBeanModel {

    public void m1() {
        System.out.println("正在调用 ==> m1()");
    }

    public String m2(String msg) {
        return String.format("foo ==> " + msg);
    }
}
