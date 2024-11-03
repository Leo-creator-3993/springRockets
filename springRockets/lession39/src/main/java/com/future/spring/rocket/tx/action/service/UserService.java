package com.future.spring.rocket.tx.action.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MsgSender msgSender;

    @Transactional
    public void register(Integer userId, String userName) {
        this.jdbcTemplate.update("insert into t_user(id, name) values(?, ?)", userId, userName);
        System.out.println(String.format("用户注册:[userId:%s, userName:%s]", userId, userName));
        String msg = String.format("[userId:%s, userName:%s]", userId, userName);
        this.msgSender.send(msg, 1, userId.toString());
    }

    //模拟用户注册失败，咱们通过弹出异常让事务回滚，结果也会导致消息发送被取消
    @Transactional
    public void registerFail(Integer userId, String userName) {
        this.register(userId, userName);
        throw new RuntimeException("抛出异常以使事务失败");
    }

    //事务传播属性是REQUIRES_NEW,会在独立的事务中运行
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void registerRequiresNew(Integer userId, String userName) {
        this.register(userId, userName);
    }
}
