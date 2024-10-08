package com.future.spring.rocket.impl;

import com.future.spring.rocket.IUserService;

public class UserServiceImpl implements IUserService {

    @Override
    public void insert(String msg) {
        System.out.println("插入数据: " + msg);
    }
}
