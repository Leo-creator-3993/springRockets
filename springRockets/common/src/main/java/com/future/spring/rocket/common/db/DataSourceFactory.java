package com.future.spring.rocket.common.db;



import javax.sql.DataSource;

public interface DataSourceFactory {
    DataSource createDataSource(ConfigLoader configLoader);
}
