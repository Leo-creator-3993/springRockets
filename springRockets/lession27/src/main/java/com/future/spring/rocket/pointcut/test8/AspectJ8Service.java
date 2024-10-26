package com.future.spring.rocket.pointcut.test8;

public class AspectJ8Service {

    public void m1(Car car) {
        System.out.println("调用 ==> m1() , car ==> " + car);
    }

    @Ann8
    public static class Car {
        @Override
        public String toString() {
            return "BYD";
        }
    }
}
