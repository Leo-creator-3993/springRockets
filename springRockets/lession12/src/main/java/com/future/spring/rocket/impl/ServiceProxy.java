package com.future.spring.rocket.impl;

import com.future.spring.rocket.IProxyService;
import org.springframework.util.StopWatch;

public class ServiceProxy implements IProxyService {

    private IProxyService proxyService;

    public ServiceProxy(IProxyService proxyService) {
        this.proxyService = proxyService;
    }

    @Override
    public void m1() {
        StopWatch stopWatch = new StopWatch("task-m1");
        stopWatch.start();
        proxyService.m1();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    @Override
    public void m2() {
        StopWatch stopWatch = new StopWatch("task-m2");
        stopWatch.start();
        proxyService.m2();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
