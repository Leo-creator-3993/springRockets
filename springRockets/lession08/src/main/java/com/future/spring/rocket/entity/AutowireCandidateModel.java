package com.future.spring.rocket.entity;

public class AutowireCandidateModel {

    public interface IService{}
    public static class ServiceA implements IService{}
    public static class ServiceB implements IService{}

    private IService service;
    public void setService(IService service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return String.format("IService, info:%s", service);
    }
}
