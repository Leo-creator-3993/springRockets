package com.future.spring.rocket.common.db.impl;

import com.future.spring.rocket.common.db.ConfigLoader;
import com.future.spring.rocket.common.db.DataSourceFactory;

import javax.sql.DataSource;

public class TomcatDataSourceFactory implements DataSourceFactory {

    @Override
    public DataSource createDataSource(ConfigLoader configLoader) {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName(configLoader.getProperty("db.driverClass"));
        dataSource.setUrl(configLoader.getProperty("db.url"));
        dataSource.setUsername(configLoader.getProperty("db.user"));
        dataSource.setPassword(configLoader.getProperty("db.pass"));
        dataSource.setInitialSize(5);
        return dataSource;
    }
}
