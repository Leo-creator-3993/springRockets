package com.future.spring.rocket.custom;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ThreadScope implements Scope {

    private ThreadLocal<Map<String, Object>> objectMap = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return new HashMap<>();
        }
    };

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        Object bean = objectMap.get().get(s);
        if(Objects.isNull(bean)) {
            bean = objectFactory.getObject();
            objectMap.get().put(s, bean);
        }
        return bean;
    }

    @Override
    public Object remove(String s) {
        return objectMap.get().remove(s);
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {
        System.out.println(s);
    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return Thread.currentThread().getName();
    }
}
