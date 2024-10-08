package com.future.spring.rocket.factory;

import com.future.spring.rocket.entity.UserModel;
import org.springframework.beans.factory.FactoryBean;

public class UserModelFactoryBean implements FactoryBean<UserModel> {

    int count = 1;
    private String name;
    private int age;

    public UserModelFactoryBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public UserModel getObject() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setName(name + count);
        userModel.setAge(age);
        ++count;
        return userModel;
    }

    @Override
    public Class<?> getObjectType() {
        return UserModel.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
