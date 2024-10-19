package com.future.spring.rocket.proxy.dispatchtest;

public class DispatchModel {
    private String name;

    public DispatchModel() {

    }

    public DispatchModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void greet(String msg) {
        System.out.println("hi, " + name + "," + msg);
    }
}
