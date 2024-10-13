package com.future.spring.rocket.bean.definition.test4;

public class Person {
    private String name;
    private int age;

    public Person() {
        System.out.println("调用Person()");
    }

    @InvokeAnn
    public Person(String name) {
        System.out.println("调用Person(String name)");
        this.name =name;
    }

    @InvokeAnn
    public Person(String name, int age) {
        System.out.println("调用Person(String name, int age)");
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("name:%s, age:%s", name, age);
    }
}
