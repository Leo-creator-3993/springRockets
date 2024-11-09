package com.future.spring.rocket.tx.order;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestTxOrderMain {

    private UserService userService;
    private JdbcTemplate jdbcTemplate;

    @Before()
    public void before() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        userService = (UserService) context.getBean("userService");
        this.jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        jdbcTemplate.update("delete from t_user");
    }


    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        userService.insert();
    }
}
