package com.future.spring.rocket.mybatis.mapper;

import com.future.spring.rocket.mybatis.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    void truncateTable();

    void insert(UserModel userModel);

    List<UserModel> selectAll();
}
