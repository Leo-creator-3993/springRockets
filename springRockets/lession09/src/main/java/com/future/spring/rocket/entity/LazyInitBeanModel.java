package com.future.spring.rocket.entity;

public class LazyInitBeanModel {
    public LazyInitBeanModel() {
        System.out.println(String.format("Bean class:%s", this.getClass()));
    }

    @Override
    public String toString() {
        return String.format("I am LazyInitBean, Life , Good, Day...");
    }
}
