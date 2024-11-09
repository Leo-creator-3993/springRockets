package com.future.spring.rocket.mybatis.service.impl;

import com.future.spring.rocket.mybatis.mapper.UserMapper;
import com.future.spring.rocket.mybatis.model.UserModel;
import com.future.spring.rocket.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insert(UserModel userModel) {
        System.out.println("开始执行插入userModel ==> " + userModel);
        userMapper.insert(userModel);
        System.out.println("结束插入");
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<UserModel> findAll() {
        System.out.println("开始获取userModel...");
        return userMapper.selectAll();
    }

    @Override
    public void truncate() {
        System.out.println("开始初始化清空表格数据...");
        userMapper.truncateTable();
    }
}
