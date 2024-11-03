package com.future.spring.rocket.tx.action.service;

import com.future.spring.rocket.tx.action.model.MsgOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MsgOrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MsgOrderModel insert(int refType, String refId) {
        MsgOrderModel msgOrderModel = MsgOrderModel.builder().refType(refType).refId(refId).build();

        this.jdbcTemplate.update("insert into t_msg_order(ref_type,ref_id) values(?,?)", refType, refId);
        msgOrderModel.setId(this.jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return msgOrderModel;
    }

    public MsgOrderModel getById(int id) {
        List<MsgOrderModel> list = this.jdbcTemplate.query("select * from t_msg_order where id = ? limit 1", new BeanPropertyRowMapper<MsgOrderModel>(MsgOrderModel.class), id);
        return Objects.nonNull(list) && !list.isEmpty() ? list.get(0) : null;
    }
}
