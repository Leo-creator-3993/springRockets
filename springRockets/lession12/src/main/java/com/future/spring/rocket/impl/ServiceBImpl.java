package com.future.spring.rocket.impl;

import com.future.spring.rocket.IProxyService;

public class ServiceBImpl implements IProxyService {
    @Override
    public void m1() {
        System.out.println(this.getClass() + "#m1");
    }

    @Override
    public void m2() {
        System.out.println(this.getClass() + "#m2");
    }
}
