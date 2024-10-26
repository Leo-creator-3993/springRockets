package com.future.spring.rocket.pointcut.test3;

public class AspectJ3Impl implements IAspectJ3 {

    @Override
    public void m3() {
        System.out.println("调用 ==> IAspectJ3Impl.m3()");
    }
}
