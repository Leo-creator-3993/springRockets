package com.future.spring.rocket.entity;

public class CompositeInitBeanModel {
    public static class LazyModel {
        public LazyModel() {
            System.out.println(String.format("Bean class:%s", this.getClass()));
        }
    }

    public CompositeInitBeanModel() {
        System.out.println(String.format("Bean class:%s", this.getClass()));
    }

    private LazyModel lazyModel;

    public LazyModel getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyModel lazyModel) {
        this.lazyModel = lazyModel;
        System.out.println("CompositeInitBeanModel, invoke LazyModel#setLazyModel");
    }
}
