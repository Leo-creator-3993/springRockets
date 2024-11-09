package com.future.spring.rocket.tx.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void insert() {
        System.out.println("Start insert into user...");
        jdbcTemplate.update("insert into t_user(id, name) values(?, ?)", 9527, "Leo");
        System.out.println("End insert into user...");
    }
}
