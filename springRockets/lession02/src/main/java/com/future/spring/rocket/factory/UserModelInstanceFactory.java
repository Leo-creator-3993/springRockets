package com.future.spring.rocket.factory;

import com.future.spring.rocket.entity.UserModel;

public class UserModelInstanceFactory {
    public  UserModel instanceUserModel1() {
        System.out.println("build userModel1...");
        return new UserModel();
    }

    public  UserModel instanceUserModel2(String name, int age) {
        System.out.println("build userModel2...");
        return new UserModel(name, age);
    }
}
