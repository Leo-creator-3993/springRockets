package com.future.spring.rocket.redis.test1;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BaseService {

    @Cacheable(cacheNames = {"foo"}, key = "#root.targetClass.name+'-'+#root.method.name")
    public List<String> listFoo() {
        System.out.println("--- get data from db ---");
        return Arrays.asList("LeoLeo", "FooFoo", "DayDay");
    }
}
