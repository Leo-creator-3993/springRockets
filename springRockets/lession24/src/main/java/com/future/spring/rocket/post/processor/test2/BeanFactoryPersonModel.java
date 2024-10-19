package com.future.spring.rocket.post.processor.test2;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanFactoryPersonModel {

    @Autowired
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeanFactoryPersonModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
