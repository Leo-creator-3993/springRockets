package com.future.spring.rocket.jdbctemplate.source;

import javax.sql.DataSource;

public class DbSource {

    private static final String JDBC_DRIVER_CLASS =  "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&useSSL=false";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "rootroot";

    private DbSource() {
    }

    private static DbSource INSTANCE = new DbSource();

    public static DbSource getINSTANCE() {
        return INSTANCE;
    }

    public DataSource get() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName(JDBC_DRIVER_CLASS);
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDBC_USER);
        dataSource.setPassword(JDBC_PASS);
        dataSource.setInitialSize(5);
        return dataSource;
    }
}

