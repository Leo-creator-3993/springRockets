package com.future.spring.rocket.db.split.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class ReadWriteDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DbTypeHolder.getDbType();
    }
}
