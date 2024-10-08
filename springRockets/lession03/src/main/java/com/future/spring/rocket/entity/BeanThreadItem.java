package com.future.spring.rocket.entity;

public class BeanThreadItem {

    public BeanThreadItem(String scope) {
        System.out.println(String.format("开始创建Bean, thread:%s, scope:%s, bean:%s", Thread.currentThread(), scope, this));
    }
}
