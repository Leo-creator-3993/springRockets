package com.future.spring.rocket.db.split;

import com.future.spring.rocket.db.split.db.DbType;
import com.future.spring.rocket.db.split.interceptor.DbTypeConfiguration;
import com.future.spring.rocket.db.split.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDbSplitMain {

    private UserService userService;

    private JdbcTemplate jdbcTemplate;

    @Before
    public void before() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbTypeConfiguration.class);
        userService = (UserService) context.getBean("userService");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        jdbcTemplate.update("delete from master.t_user");
        jdbcTemplate.update("delete from slave.t_user");
    }


    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        //主库插入
        userService.insert("LeoLeo", DbType.MASTER);
        //从库插入
        userService.insert("FooFoo", DbType.SLAVE);
    }

    @Test
    public void test2() {
        userService.insert("Lin", DbType.MASTER);
        userService.insert("Yao", DbType.MASTER);

        userService.insert("Zhou", DbType.SLAVE);
        userService.insert("Wang", DbType.SLAVE);

        System.out.println("主库数据 ==>" + userService.getByBbType(DbType.MASTER));
        System.out.println("从库数据 ==> " + userService.getByBbType(DbType.SLAVE));
    }
}
