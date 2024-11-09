package com.future.spring.rocket.mybatis.service;

import com.future.spring.rocket.mybatis.model.UserModel;

import java.util.List;

public interface IUserService {

    void insert(UserModel userModel);

    List<UserModel> findAll();

    void truncate();
}
