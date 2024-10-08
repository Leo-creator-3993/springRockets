package com.future.spring.rocket.entity;

import lombok.Data;

public class DiAutowireConstructorModel {

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

    private Service1 service1;
    private Service2 service2;

    public DiAutowireConstructorModel(){

    }

    public DiAutowireConstructorModel(Service1 service1) {
        this.service1 = service1;
    }

    public DiAutowireConstructorModel(Service1 service1, Service2 service2) {
        this.service1 = service1;
        this.service2 = service2;
    }

    @Override
    public String toString() {
        return String.format("autowireConstructorModel service1:%s, service2:%s", service1, service2);
    }
}
