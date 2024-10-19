package com.future.spring.rocket.proxy.cglibtest;

public class ServiceCgLibInstance implements IServiceC1{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String greet(String msg) {
        System.out.println("Invoke greet()");
        return String.format("Penis,%s.", msg);
    }

    @Override
    public int c1(String msg) {
        return msg.length();
    }
}
