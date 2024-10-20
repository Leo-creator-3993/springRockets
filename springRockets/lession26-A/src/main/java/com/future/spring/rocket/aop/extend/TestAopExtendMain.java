package com.future.spring.rocket.aop.extend;

import com.future.spring.rocket.aop.extend.model.FoundService;
import com.future.spring.rocket.common.util.OtherUtil;
import org.junit.jupiter.api.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class TestAopExtendMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        FoundService foundService = new FoundService();
        foundService.setName("Leo");
        ProxyFactory proxyFactory = new ProxyFactory(foundService);
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                if(objects.length > 0) {
                    String userName = (String) objects[0];
                    if (!"Leo".equals(userName)) {
                        throw new RuntimeException("用户 ==> " + userName + "==>" + method.getName() + " 非法访问!");
                    }
                }
            }
        });

        FoundService proxy = (FoundService) proxyFactory.getProxy();
        try {
            proxy.deposit("Mark", 1000);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            proxy.withdrawal("Mark", 100);
        }catch (Exception e) {
            //test...
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("用户余额 ==>" + proxy.getBalance("Mark"));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        OtherUtil.splitLinePrint();
        proxy.deposit("Leo", 1000);
        proxy.withdrawal("Leo", 100);
        System.out.println("用户余额 ==>" + proxy.getBalance("Leo"));
    }
}
