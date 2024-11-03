package com.future.spring.rocket.tx.action;

import com.future.spring.rocket.tx.action.service.UserService;
import com.future.spring.rocket.tx.action.service.UserServiceX;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestTxActionMain {

    private AnnotationConfigApplicationContext applicationContext;
    private UserService userService;
    private JdbcTemplate jdbcTemplate;

    @Before
    public void before() {
        this.applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        this.userService = (UserService) applicationContext.getBean("userService");
        this.jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        jdbcTemplate.update("delete from t_user");
        jdbcTemplate.update("delete from t_msg");
        jdbcTemplate.update("delete from t_msg_order");
    }

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        this.userService.register(9527, "Leo");
    }

    @Test
    public void test2() {
        this.userService.registerFail(42, "Foo");
    }

    @Test
    public void test3() {
        UserServiceX userServiceX = (UserServiceX) applicationContext.getBean("userServiceX");
        userServiceX.nested();
    }
}
