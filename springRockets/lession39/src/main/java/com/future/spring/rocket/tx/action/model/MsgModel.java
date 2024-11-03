package com.future.spring.rocket.tx.action.model;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MsgModel implements Serializable {
    private static final long serialVersionUID = -8832293812138666616L;

    //表主键
    private int id;
    //消息内容
    private String msg;
    //消息订单id
    private int msgOrderId;
    //消息状态: 0-待投递, 1-已发送, 2-取消发送
    private int status;
}
