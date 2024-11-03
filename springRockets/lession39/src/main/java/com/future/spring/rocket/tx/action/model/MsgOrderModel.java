package com.future.spring.rocket.tx.action.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MsgOrderModel {
    //主键
    private int id;

    //关联业务类型
    private int refType;

    //关联业务id
    private String refId;
}
