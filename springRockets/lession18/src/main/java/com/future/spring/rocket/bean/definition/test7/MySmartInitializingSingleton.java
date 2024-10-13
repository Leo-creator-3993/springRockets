package com.future.spring.rocket.bean.definition.test7;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class MySmartInitializingSingleton implements SmartInitializingSingleton {
    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("所有bean初始化完毕!");
    }
}
