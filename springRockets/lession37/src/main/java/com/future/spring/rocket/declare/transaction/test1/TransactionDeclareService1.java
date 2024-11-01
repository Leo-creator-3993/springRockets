package com.future.spring.rocket.declare.transaction.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class TransactionDeclareService1 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = {Exception.class})
    public int batchInsert(String ... name) {
        System.out.println("开始调用 ==> batchInsert()...");
        int affectedRow = 0;
        //truncate是非事务性的,失败也不会回滚
        //jdbcTemplate.update("truncate table t_userX");
        jdbcTemplate.update("delete from t_userX");
        for(String item : name) {
            affectedRow += jdbcTemplate.update("insert into t_userX(name) values(?)", item);
        }
        System.out.println("结束调用 ==> batchInsert()!");
        return affectedRow;
    }

    //反向的非回滚事务插入方法
    @Transactional(noRollbackFor = {Exception.class})
    public int xBatchInsert(List<String> nameList) {
        System.out.println("开始调用 ==> xBatchInsert()...");
        int affectedRow = 0;
        //truncate是非事务性的,失败也不回滚
        jdbcTemplate.update("delete from t_userX");
        for(String item : nameList) {
            affectedRow += jdbcTemplate.update("insert into t_userX(name) values(?)", item);
        }
        System.out.println("结束调用 ==> xBatchInsert()!");
        return affectedRow;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> list() {
        System.out.println("开始调用 ==> list()...");
        return jdbcTemplate.queryForList("select * from t_userX");
    }
}
