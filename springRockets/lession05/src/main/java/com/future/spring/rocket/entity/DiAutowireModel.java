package com.future.spring.rocket.entity;

import lombok.Data;

public class DiAutowireModel {

    @Data
    public static class Service1 {
        private String desc;

        @Override
        public String toString() {
           return String.format("service1, desc:%s", desc);
        }
    }

    @Data
    public static class Service2 {
        private String desc;

        @Override
        public String toString() {
            return String.format("service2, desc:%s", desc);
        }
    }

    public Service1 getService1() {
        return service1;
    }

    public void setService1(Service1 service1) {
        System.out.println("Invoke DiAutowireModel service1");
        this.service1 = service1;
    }

    public Service2 getService2() {
        return service2;
    }

    public void setService2(Service2 service2) {
        System.out.println("Invoke DiAutowireModel service2");
        this.service2 = service2;
    }

    private Service1 service1;
    private Service2 service2;

    @Override
    public String toString() {
        return String.format("DiAutowire service1:%s, service2:%s", service1, service2);
    }
}
