package com.future.spring.rocket.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

public class DiAutowireModelExtend {

    public  interface IService {
    }

    @Data
    public static class BaseService {
        private String desc;

        @Override
        public String toString() {
            return String.format("BaseService, desc:%s", desc);
        }
    }

    @Data
    public static class Service1 extends BaseService implements IService{
        private String spec;
        @Override
        public String toString() {
           return String.format("service1, spec:%s", spec);
        }
    }

    @Data
    public static class Service2 extends BaseService implements IService{
        private String spec;

        @Override
        public String toString() {
            return String.format("service2, spec:%s", spec);
        }
    }

    private Service1 service1;
    private Service2 service2;


    public Service1 getService1() {
        return service1;
    }

    public void setService1(Service1 service1) {
        this.service1 = service1;
    }

    public Service2 getService2() {
        return service2;
    }

    public void setService2(Service2 service2) {
        this.service2 = service2;
    }

    public List<IService> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<IService> serviceList) {
        this.serviceList = serviceList;
    }

    public List<BaseService> getBaseServiceList() {
        return baseServiceList;
    }

    public void setBaseServiceList(List<BaseService> baseServiceList) {
        this.baseServiceList = baseServiceList;
    }

    public Map<String, IService> getServiceMap() {
        return serviceMap;
    }

    public void setServiceMap(Map<String, IService> serviceMap) {
        this.serviceMap = serviceMap;
    }

    public Map<String, BaseService> getBaseServiceMap() {
        return baseServiceMap;
    }

    public void setBaseServiceMap(Map<String, BaseService> baseServiceMap) {
        this.baseServiceMap = baseServiceMap;
    }

    private List<IService> serviceList;
    private List<BaseService> baseServiceList;
    private Map<String, IService> serviceMap;
    private Map<String, BaseService> baseServiceMap;

    @Override
    public String toString() {
        return String.format("DiAutowireModelExtend serviceList:%s, baseServiceList:%s, serviceMap:%s, baseServiceMap:%s", serviceList, baseServiceList, serviceMap, baseServiceMap);
    }
}
