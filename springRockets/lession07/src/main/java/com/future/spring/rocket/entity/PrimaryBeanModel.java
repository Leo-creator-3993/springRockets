package com.future.spring.rocket.entity;

public class PrimaryBeanModel {

    public interface IService{}

    public static class ServiceA implements IService{
        private String info;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        @Override
        public String toString() {
            return String.format("ServiceA, info:%s", info);
        }
    }
    public static class ServiceB implements IService{
        private String info;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        @Override
        public String toString() {
            return String.format("ServiceB, info:%s", info);
        }
    }

//    public PrimaryBeanModel() {
//    }

    private IService service;

    public PrimaryBeanModel(IService service) {
        this.service = service;
    }


//    public void setiService(IService iService) {
//        this.iService = iService;
//    }

    @Override
    public String toString() {
        return String.format("PrimaryBeanModel, service info:%s", service);
    }
}
