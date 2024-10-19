package com.future.spring.rocket.proxy.naming;

public class Foo {
    private String foo;
    public Foo(String foo) {
        this.foo = foo;
    }

    public Foo() {
        System.out.println("Invoke default constructor...");
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
}
