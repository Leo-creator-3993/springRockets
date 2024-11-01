package com.future.spring.rocket.source.transaction;

import com.future.spring.rocket.common.db.ConfigLoader;
import com.future.spring.rocket.common.db.DataSourceFactory;
import com.future.spring.rocket.common.db.DbUtil;
import com.future.spring.rocket.common.db.impl.FileConfigLoader;
import com.future.spring.rocket.common.db.impl.TomcatDataSourceFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;

public class TestTransactionSourceMain {

    private JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager platformTransactionManager;

    @Before
    public void before() {
        System.out.println("开始执行前置动作 ==> before()...");
        ConfigLoader configLoader = new FileConfigLoader("db.properties");
        DataSourceFactory dataSourceFactory = new TomcatDataSourceFactory();
        DbUtil dbUtil = new DbUtil(configLoader, dataSourceFactory);
        DataSource dataSource = dbUtil.getDataSource();

        jdbcTemplate = new JdbcTemplate(dataSource);
        platformTransactionManager = new DataSourceTransactionManager(dataSource);

        System.out.println("执行truncate动作...");
        jdbcTemplate.update("delete from t_userX");
    }

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        System.out.println("PROPAGATION_REQUIRED start");
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
        //开启事务
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        this.addSynchronization("ts1-1", 2);
        this.addSynchronization("ts1-2", 1);
        jdbcTemplate.update("insert into t_userX(name) values(?)", "test1-1");
        jdbcTemplate.update("insert into t_userX(name) values(?)", "test1-2");
        this.test2();
        System.out.println("PROPAGATION_REQUIRED 准备commit");
        platformTransactionManager.commit(transactionStatus);
        System.out.println("PROPAGATION_REQUIRED commit完毕");

        System.out.println("after ==> " + jdbcTemplate.queryForList("select * from t_userX"));
    }

    public void test2() {
        System.out.println("PROPAGATION_REQUIRED_NEW start");
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        jdbcTemplate.update("insert into t_userX(name) values(?)", "test2-1");
        jdbcTemplate.update("insert into t_userX(name) values(?)", "test2-2");
        this.addSynchronization("ts2-1", 2);
        this.addSynchronization("ts2-2", 1);
        System.out.println("PROPAGATION_REQUIRED_NEW 准备commit");
        platformTransactionManager.commit(transactionStatus);
        System.out.println("PROPAGATION_REQUIRED_NEW commit完毕");
    }


    public void addSynchronization(final String name, final int order) {
        if(TransactionSynchronizationManager.isSynchronizationActive()) {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public int getOrder() {
                    return order;
                }

                @Override
                public void suspend() {
                    System.out.println(name + ":suspend");
                }

                @Override
                public void resume() {
                    System.out.println(name + ":resume");
                }

                @Override
                public void flush() {
                    System.out.println(name + ":flush");
                }

                @Override
                public void beforeCommit(boolean readOnly) {
                    System.out.println(name + ":beforeCommit==>" + readOnly);
                }

                @Override
                public void beforeCompletion() {
                    System.out.println(name + ":beforeCompletion");
                }

                @Override
                public void afterCommit() {
                    System.out.println(name + ":afterCommit");
                }

                @Override
                public void afterCompletion(int status) {
                    System.out.println(name + ":afterCompletion==>" + status);
                }
            });
        }

    }
}
