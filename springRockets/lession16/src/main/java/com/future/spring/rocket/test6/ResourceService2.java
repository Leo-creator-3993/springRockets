package com.future.spring.rocket.test6;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ResourceService2 {

    @Resource
    private ResourceService1 resourceService1;

    @Override
    public String toString() {
        return String.format("resourceService1:%s", resourceService1);
    }
}
