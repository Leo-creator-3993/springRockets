package com.future.spring.rocket.bean.definition.test6;

import org.springframework.beans.factory.InitializingBean;

public class MyServiceInit implements InitializingBean {

    public void init0() {
        System.out.println("调用init0()方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用afterPropertiesSet()方法");
    }
}
