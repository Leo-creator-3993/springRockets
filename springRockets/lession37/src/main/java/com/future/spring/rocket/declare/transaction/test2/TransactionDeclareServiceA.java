package com.future.spring.rocket.declare.transaction.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionDeclareServiceA {

    @Autowired
    private TransactionDeclareServiceB transactionDeclareServiceB;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void m1() {
        jdbcTemplate.update("delete from t_userX");
        try {
            transactionDeclareServiceB.m2();
        } catch (Exception e) {
            System.out.println("异常发生 ==> "+ e.getMessage());
        }
        jdbcTemplate.update("insert into t_userX (name) values ('zs')");
    }

    public  void printList() {
        System.out.println(jdbcTemplate.queryForList("select * from t_userX"));
    }
}
