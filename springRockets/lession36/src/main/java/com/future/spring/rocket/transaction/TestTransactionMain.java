package com.future.spring.rocket.transaction;


import com.future.spring.rocket.common.db.ConfigLoader;
import com.future.spring.rocket.common.db.DataSourceFactory;
import com.future.spring.rocket.common.db.DbUtil;
import com.future.spring.rocket.common.db.impl.FileConfigLoader;
import com.future.spring.rocket.common.db.impl.TomcatDataSourceFactory;
import com.future.spring.rocket.common.util.OtherUtil;
import com.future.spring.rocket.transaction.testX.MainConfig;
import com.future.spring.rocket.transaction.testX.TransactionService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.function.Consumer;

public class TestTransactionMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        ConfigLoader configLoader = new FileConfigLoader("db.properties");
        DataSourceFactory dataSourceFactory = new TomcatDataSourceFactory();
        DbUtil dbUtil = new DbUtil(configLoader, dataSourceFactory);
        DataSource dataSource = dbUtil.getDataSource();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        PlatformTransactionManager platformTransactionManager = new DataSourceTransactionManager(dataSource);
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);

        try{
            jdbcTemplate.update("delete from t_userX");
            System.out.println("before ==> " + jdbcTemplate.queryForList("select * from t_userX"));
            jdbcTemplate.update("insert into t_userX (name) values (?)", "foo");
            jdbcTemplate.update("insert into t_userX (name) values (?)", "leo");
            platformTransactionManager.commit(transactionStatus);
        } catch (Exception e) {
            System.out.println("发生异常,事务将回滚 ==>" + e);
            platformTransactionManager.rollback(transactionStatus);
        }
        System.out.println("after ==> " + jdbcTemplate.queryForList("select * from t_userX"));
    }

    @Test
    public void test1_rollback() {
        ConfigLoader configLoader = new FileConfigLoader("db.properties");
        DataSourceFactory dataSourceFactory = new TomcatDataSourceFactory();
        DbUtil dbUtil = new DbUtil(configLoader, dataSourceFactory);
        DataSource dataSource = dbUtil.getDataSource();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        PlatformTransactionManager platformTransactionManager = new DataSourceTransactionManager(dataSource);
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);

        try{
            System.out.println("before ==> " + jdbcTemplate.queryForList("select * from t_userX"));
            jdbcTemplate.update("delete from t_userX");
            jdbcTemplate.update("insert into t_userX (name) values (?)", "rollback");
            jdbcTemplate.update("insert into t_userX (name) values (?)", "rollback");
            platformTransactionManager.commit(transactionStatus);
        } catch (Exception e) {
            System.out.println("发生异常,事务将回滚 ==>" + e);
            platformTransactionManager.rollback(transactionStatus);
        }
    }

    @Test
    public void test2() {
        ConfigLoader configLoader = new FileConfigLoader("db.properties");
        DataSourceFactory dataSourceFactory = new TomcatDataSourceFactory();
        DbUtil dbUtil = new DbUtil(configLoader, dataSourceFactory);
        DataSource dataSource = dbUtil.getDataSource();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        PlatformTransactionManager platformTransactionManager = new DataSourceTransactionManager(dataSource);
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager, transactionDefinition);
        transactionTemplate.executeWithoutResult(new Consumer<TransactionStatus>() {
            @Override
            public void accept(TransactionStatus transactionStatus) {
                jdbcTemplate.update("delete from t_userX where name in ('day', 'etc')");
                jdbcTemplate.update("insert into t_userX (name) values (?)", "day");
                jdbcTemplate.update("insert into t_userX (name) values (?)", "etc");
            }
        });
        System.out.println("==> " + jdbcTemplate.queryForList("select * from t_userX"));
    }

    @Test
    public void test2_exp() {
        ConfigLoader configLoader = new FileConfigLoader("db.properties");
        DataSourceFactory dataSourceFactory = new TomcatDataSourceFactory();
        DbUtil dbUtil = new DbUtil(configLoader, dataSourceFactory);
        DataSource dataSource = dbUtil.getDataSource();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        PlatformTransactionManager platformTransactionManager = new DataSourceTransactionManager(dataSource);
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager, transactionDefinition);
        transactionTemplate.executeWithoutResult(new Consumer<TransactionStatus>() {
            @Override
            public void accept(TransactionStatus transactionStatus) {
                jdbcTemplate.update("delete from t_userX where name in ('exp')");
                jdbcTemplate.update("insert into t_userX (name) values (?)", "exp");
                jdbcTemplate.update("insert into t_userX (name) values (?)", "exp");
            }
        });
        System.out.println("==> " + jdbcTemplate.queryForList("select * from t_userX"));
    }

    @Test
    public void test3() {
        ConfigLoader configLoader = new FileConfigLoader("db.properties");
        DataSourceFactory dataSourceFactory = new TomcatDataSourceFactory();
        DbUtil dbUtil = new DbUtil(configLoader, dataSourceFactory);
        DataSource dataSource = dbUtil.getDataSource();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        PlatformTransactionManager platformTransactionManager = new DataSourceTransactionManager(dataSource);
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        transactionDefinition.setTimeout(5000);
        TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager, transactionDefinition);
        Object result =transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                jdbcTemplate.update("delete from t_userX where name in ('fooFoo')");
                int result;
                result = jdbcTemplate.update("insert into t_userX(name) values(?)", "fooFoo");
                return result;
            }
        });
        System.out.println("==> result " + result + ", set ==> " + jdbcTemplate.queryForList("select * from t_userX"));
    }

    @Test
    public void test3_exp() {
        ConfigLoader configLoader = new FileConfigLoader("db.properties");
        DataSourceFactory dataSourceFactory = new TomcatDataSourceFactory();
        DbUtil dbUtil = new DbUtil(configLoader, dataSourceFactory);
        DataSource dataSource = dbUtil.getDataSource();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        PlatformTransactionManager platformTransactionManager = new DataSourceTransactionManager(dataSource);
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        transactionDefinition.setTimeout(5000);
        TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager, transactionDefinition);
        Object result =transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                jdbcTemplate.update("delete from t_userX where name in ('LeoLeo')");
                int result;
                jdbcTemplate.update("insert into t_userX(name) values(?)", "LeoLeo");
                result = jdbcTemplate.update("insert into t_userX(name) values(?)", "LeoLeo");
                return result;
            }
        });
        System.out.println("==> result " + result + ", set ==> " + jdbcTemplate.queryForList("select * from t_userX"));
    }

    @Test
    public void test5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        TransactionService transactionService = context.getBean(TransactionService.class);
        transactionService.m1();
        OtherUtil.splitLinePrint();
        System.out.println("第1结果集 ==>" + transactionService.queryList());
        OtherUtil.splitLinePrint();
        try {
            transactionService.x();
        } catch (Exception e) {
            System.out.println("异常 ==> " + e.getMessage());
        }
        OtherUtil.splitLinePrint();
        System.out.println("第2结果集 ==>" + transactionService.queryList());
    }
}
