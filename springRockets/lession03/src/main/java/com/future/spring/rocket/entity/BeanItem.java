package com.future.spring.rocket.entity;

public class BeanItem {

    public BeanItem(String scope) {
        System.out.println(String.format("开始创建Bean, scope:%s, bean:%s%n", scope, this));
    }
}
