package com.future.spring.rocket.db.split.interceptor;

import com.future.spring.rocket.common.db.ConfigLoader;
import com.future.spring.rocket.common.db.DataSourceFactory;
import com.future.spring.rocket.common.db.DbUtil;
import com.future.spring.rocket.common.db.impl.FileConfigLoader;
import com.future.spring.rocket.common.db.impl.TomcatDataSourceFactory;
import com.future.spring.rocket.db.split.db.DbType;
import com.future.spring.rocket.db.split.db.ReadWriteDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.future.spring.rocket.db.split"})
public class DbTypeConfiguration {
    @Bean
    public DataSource masterDataSource() {
        ConfigLoader configLoader = new FileConfigLoader("db-master.properties");
        DataSourceFactory dataSourceFactory = new TomcatDataSourceFactory();
        DbUtil dbUtil = new DbUtil(configLoader, dataSourceFactory);
        return dbUtil.getDataSource();
    }

    @Bean
    public DataSource slaveDataSource() {
        ConfigLoader configLoader = new FileConfigLoader("db-slave.properties");
        DataSourceFactory dataSourceFactory = new TomcatDataSourceFactory();
        DbUtil dbUtil = new DbUtil(configLoader, dataSourceFactory);
        return dbUtil.getDataSource();
    }

    @Bean
    public ReadWriteDataSource dataSource() {
        ReadWriteDataSource readWriteDataSource = new ReadWriteDataSource();
        readWriteDataSource.setDefaultTargetDataSource(masterDataSource());

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DbType.MASTER, this.masterDataSource());
        targetDataSources.put(DbType.SLAVE, this.slaveDataSource());
        readWriteDataSource.setTargetDataSources(targetDataSources);
        return readWriteDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
