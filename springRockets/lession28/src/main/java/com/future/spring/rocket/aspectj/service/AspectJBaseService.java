package com.future.spring.rocket.aspectj.service;

public class AspectJBaseService {

    public void greet(String name) {
        System.out.println("你好, " + name);
    }

    public int getLen(String msg) {
        System.out.println("调用 ==> getLen()");
        return msg.length();
    }

    public void login(String name) {
        if(!"Leo".equals(name)) {
            throw new IllegalArgumentException(name + " 非法访问!");
        }
        System.out.println(name + " 登录成功!");
    }
}
