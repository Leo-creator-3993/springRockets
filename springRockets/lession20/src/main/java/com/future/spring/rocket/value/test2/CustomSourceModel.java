package com.future.spring.rocket.value.test2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomSourceModel {

    @Value("${mail.host}")
    private String mailHost;

    @Value("${mail.userName}")
    private String mailUserName;

    @Value("${mail.passwd}")
    private String mailPasswd;

    @Value("${mail.port:2587}")
    private String mailPort;

    //异常测试场景
    @Value("${mail.desc}")
    private String mailDesc;

    public String getMailHost() {
        return mailHost;
    }

    public String getMailUserName() {
        return mailUserName;
    }

    public String getMailPasswd() {
        return mailPasswd;
    }

    public String getMailPort() {
        return mailPort;
    }

    public String getMailDesc() {
        return mailDesc;
    }

    @Override
    public String toString() {
        return String.format("mailHost:%s, mailUser:%s, mailPasswd:%s, mailPort:%s, mailDesc:%s",
                mailHost, mailUserName, mailPasswd, mailPort, mailDesc);
    }
}
