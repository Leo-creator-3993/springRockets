package com.future.spring.rocket.tx.action.service;

import com.future.spring.rocket.tx.action.model.MsgOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class MsgSender {

    @Autowired
    private MsgOrderService msgOrderService;

    @Autowired
    private MsgService msgService;

    public void send(String msg, int refType, String refId) {
        MsgOrderModel msgOrderModel = this.msgOrderService.insert(refType, refId);
        int msgOrderId = msgOrderModel.getId();

        boolean isSynchronizationActive = TransactionSynchronizationManager.isSynchronizationActive();

        /**
         * 若事务同步开启了，那么可以在事务同步中添加事务扩展点，则先插入消息，暂不发送，则在事务扩展点中添加回调
         * 事务结束之后会自动回调扩展点TransactionSynchronizationAdapter的afterCompletion()方法
         * 咱们在这个方法中确定是否投递消息
         */
        if(isSynchronizationActive) {
            int msgId = this.msgService.addMsg(msg, msgOrderId, false);
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCompletion(int status) {
                    //代码走到这里时，事务已经完成了（可能是回滚了、或者是提交了）
                    //看一下消息关联的订单是否存在，如果存在，说明事务是成功的，业务是执行成功的，那么投递消息
                    if(msgOrderService.getById(msgOrderId) != null) {
                        System.out.println(String.format("准备投递消息,[msgId:%s]", msgId));
                        msgService.confirmMsg(msgId);
                    } else {
                        System.out.println(String.format("准备取消投递消息,[msgId:%s]", msgId));
                        msgService.cancelSendMsg(msgId);
                    }
                }
            });
        } else {
            //无事务的，直接插入并投递消息
            this.msgService.addMsg(msg, msgOrderId, true);
        }
    }
}
