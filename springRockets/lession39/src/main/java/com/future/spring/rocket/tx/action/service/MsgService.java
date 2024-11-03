package com.future.spring.rocket.tx.action.service;

import com.future.spring.rocket.tx.action.model.MsgModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class MsgService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int addMsg(String msg, int msgOrderId, boolean isSend){
        MsgModel msgModel = MsgModel.builder().msg(msg).msgOrderId(msgOrderId).status(0).build();
        int msgId = this.insert(msgModel).getId();
        if(isSend) {
            this.confirmMsg(msgId);
        }
        return msgId;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void confirmMsg(int msgId){
        MsgModel msgModel = this.getById(msgId);
        System.out.println("向 mq 投递消息 ==>" + msgModel);
        this.updateStatus(msgId, 1);
    }

    public void cancelSendMsg(int msgId){
        MsgModel msgModel = this.getById(msgId);
        System.out.println("取消向 mq 投递消息 ==>" + msgModel);
        this.updateStatus(msgId, 2);
    }

    private void updateStatus(int msgId, int status){
        this.jdbcTemplate.update("update msg set status = ? where msgId = ?", status, msgId);
    }

    private MsgModel insert(MsgModel msgModel){
        this.jdbcTemplate.update("insert into t_msg(msg, msg_order_id, status) values(?, ?, ?)",
                msgModel.getMsg(), msgModel.getMsgOrderId(), msgModel.getStatus());
        msgModel.setId(this.jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        System.out.println("插入消息 ==> " + msgModel);
        return msgModel;
    }


    private MsgModel getById(int id){
        List<MsgModel> list = this.jdbcTemplate.query("select * from t_msg where id = ?", new BeanPropertyRowMapper<>(MsgModel.class), id);
        return Objects.nonNull(list) && !list.isEmpty() ? list.get(0) : null;
    }

}
