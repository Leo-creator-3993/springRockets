package com.future.spring.rocket.value.test3;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.concurrent.ConcurrentHashMap;

public class MyRefreshScope implements Scope {

    public static final String REFRESH_SCOPE = "refreshScope";

    private static MyRefreshScope INSTANCE = new MyRefreshScope();

    private MyRefreshScope() {
    }

    public static MyRefreshScope getINSTANCE() {
        return INSTANCE;
    }

    private ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();

    public void clean () {
        INSTANCE.beanMap.clear();
    }


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object bean = beanMap.get(name);
        //System.out.println("=== Debug bean:" + bean);
        if(null == bean) {
            bean = objectFactory.getObject();
            beanMap.put(name, bean);
        }
        return bean;
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "";
    }
}
