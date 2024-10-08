package com.future.spring.rocket.entity;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class PrototypeApplicationContextModel implements ApplicationContextAware {

    private ApplicationContext context;

    public void talk() {
        PrototypeModel prototypeModel = this.getPrototypeModel();
        System.out.println(this + ", prototypeModel" + prototypeModel);
    }

    public PrototypeModel getPrototypeModel() {
        return context.getBean(PrototypeModel.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
