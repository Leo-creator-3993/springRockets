package com.future.spring.rocket.db.split.service;

import com.future.spring.rocket.db.split.db.DbType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void insert(String name, DbType dbType) {
        System.out.println("向 ==> " + dbType + " 插入数据!");
        jdbcTemplate.update("insert into t_user(name) values(?)", name);
        System.out.println("完成数据插入动作!");
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Object getByBbType(DbType dbType) {
        System.out.println("开始从 ==> " + dbType + " 读取数据...");
        String sql = "select * from t_user";
        return this.jdbcTemplate.queryForList(sql);
    }
}
