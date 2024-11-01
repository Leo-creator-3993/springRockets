package com.future.spring.rocket.common.db;

import javax.sql.DataSource;

public class DbUtil {
    private final ConfigLoader configLoader;
    private final DataSourceFactory dataSourceFactory;

    public DbUtil(ConfigLoader configLoader, DataSourceFactory dataSourceFactory) {
        this.configLoader = configLoader;
        this.dataSourceFactory = dataSourceFactory;
    }

    public DataSource getDataSource() {
        return dataSourceFactory.createDataSource(configLoader);
    }

}
