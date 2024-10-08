package com.future.spring.rocket.factory;

import com.future.spring.rocket.entity.UserModel;

public class UserModelFactory {
    public static UserModel buildUserModel1() {
        System.out.println("build userModel1...");
        return new UserModel();
    }

    public static UserModel buildUserModel2(String name, int age) {
        System.out.println("build userModel2...");
        UserModel userModel2 = new UserModel(name, age);
        return userModel2;
    }
}
