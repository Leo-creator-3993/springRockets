package com.future.spring.rocket.value.test1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueModel {

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String jdbcUserName;

    @Value("${jdbc.password}")
    private String jdbcPasswd;

    @Value("${jdbc.desc:happy}")
    private String jdbcDesc;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getJdbcUserName() {
        return jdbcUserName;
    }

    public String getJdbcPasswd() {
        return jdbcPasswd;
    }

    @Override
    public String toString(){
        return String.format("jdbcUrl:%s, jdbcUserName:%s, jdbcPasswd:%s, jdbcDesc:%s",
                jdbcUrl, jdbcUserName, jdbcPasswd, jdbcDesc);
    }
}
