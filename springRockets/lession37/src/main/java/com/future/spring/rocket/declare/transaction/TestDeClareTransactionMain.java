package com.future.spring.rocket.declare.transaction;

import com.future.spring.rocket.common.util.OtherUtil;
import com.future.spring.rocket.declare.transaction.test1.MainConfig1;
import com.future.spring.rocket.declare.transaction.test1.TransactionDeclareService1;
import com.future.spring.rocket.declare.transaction.test2.MainConfig2;
import com.future.spring.rocket.declare.transaction.test2.TransactionDeclareServiceA;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestDeClareTransactionMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();

        TransactionDeclareService1 tranService1 = context.getBean(TransactionDeclareService1.class);
        int result = tranService1.batchInsert("Leo", "Foo", "Day", "Etc.");
        System.out.println("affected row ==> " + result);

        Object qResult = tranService1.list();
        System.out.println("qResult ==> " + qResult);
    }

    @Test
    public void test1_exp() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        TransactionDeclareService1 tranService1 = context.getBean(TransactionDeclareService1.class);
        //违反数据库唯一性约束
        try {
            int result = tranService1.batchInsert("dup", "apple", "banana", "grape", "dup");
            System.out.println("affected row ==> " + result);
        } catch (Exception e) {
            System.out.println("异常发生 ==> " + e.getMessage());
        }

        //观察结果是否回滚
        List<Map<String,Object>> qResult = tranService1.list();
        System.out.println("qResult ==> " + qResult);
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();

        TransactionDeclareService1 tranService1 = context.getBean(TransactionDeclareService1.class);
        int result = tranService1.xBatchInsert(Arrays.asList("mm", "dd", "uu", "kk"));
        System.out.println("affected row ==> " + result);

        Object qResult = tranService1.list();
        System.out.println("qResult ==> " + qResult);
    }

    @Test
    public void test2_exp() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();
        TransactionDeclareService1 tranService1 = context.getBean(TransactionDeclareService1.class);
        try {
            int result = tranService1.xBatchInsert(Arrays.asList("gg", "cc", "gg"));
            System.out.println("affected row ==> " + result);
        }catch (Exception e) {
            System.out.println("异常发生 ==> " + e.getMessage());
        }

        Object qResult = tranService1.list();
        System.out.println("qResult ==> " + qResult);
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        TransactionDeclareServiceA serviceA = context.getBean(TransactionDeclareServiceA.class);
        System.out.println("before:");
        serviceA.printList();
        OtherUtil.splitLinePrint();
        try {
            serviceA.m1();
        } catch (Exception e) {
            System.out.println("==> e:" + e);
        }
        System.out.println("after:");
        serviceA.printList();
    }
}
