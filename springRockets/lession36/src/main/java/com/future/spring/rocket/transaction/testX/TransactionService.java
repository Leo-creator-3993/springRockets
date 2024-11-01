package com.future.spring.rocket.transaction.testX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class TransactionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public void m1() {
        System.out.println("开始调用 ==> m1() 方法");
        jdbcTemplate.update("delete from t_userX where name in ('insist', 'heart')");
        m2();
    }

    private void m2() {
        System.out.println("调用 ==> m2() 方法");
        transactionTemplate.executeWithoutResult(new Consumer<TransactionStatus>() {
            @Override
            public void accept(TransactionStatus transactionStatus) {
                jdbcTemplate.update("insert into t_userX(name) values(?)", "insist");
                jdbcTemplate.update("insert into t_userX(name) values(?)", "heart");
            }
        });

    }

    public void x() {
        System.out.println("开始调用 ==> x() 方法");
        transactionTemplate.executeWithoutResult(new Consumer<TransactionStatus>() {
            @Override
            public void accept(TransactionStatus transactionStatus) {
                jdbcTemplate.update("delete from t_userX where name in ('mm', 'uu', 'kk')");
                jdbcTemplate.update("insert into t_userX(name) values(?)", "mm");
                jdbcTemplate.update("insert into t_userX(name) values(?)", "uu");
                jdbcTemplate.update("insert into t_userX(name) values(?)", "kk");
                jdbcTemplate.update("insert into t_userX(name) values(?)", "mm");
            }
        });
    }

    public List<Map<String, Object>> queryList() {
        return jdbcTemplate.queryForList("select * from t_userX");
    }
}
