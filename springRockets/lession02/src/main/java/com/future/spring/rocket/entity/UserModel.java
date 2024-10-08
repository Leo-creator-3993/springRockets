package com.future.spring.rocket.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserModel {
    private String name;
    private int age;

    public UserModel() {
        this.name = "无参数构造器创建UserModel.";
    }

    public UserModel(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
