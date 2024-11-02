package com.future.spring.rocket.declare.transaction.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionDeclareServiceB {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void m2() {
        jdbcTemplate.update("insert into t_userX (name) values ('lsi')");
        throw new RuntimeException("手动抛出异常!");
    }
}
