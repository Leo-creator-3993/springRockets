package com.future.spring.rocket.entity;

public class ExtendServiceCModel {
    private String name;
    private ExtendServiceAModel serviceA;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExtendServiceAModel getServiceA() {
        return serviceA;
    }

    public void setServiceA(ExtendServiceAModel serviceA) {
        this.serviceA = serviceA;
    }

    @Override
    public String toString() {
        return String.format("ExtendServiceCModel, name:%s, ServiceA:%s", name, serviceA);
    }
}
