package com.future.spring.rocket.transaction.testX;

import com.future.spring.rocket.common.db.ConfigLoader;
import com.future.spring.rocket.common.db.DataSourceFactory;
import com.future.spring.rocket.common.db.DbUtil;
import com.future.spring.rocket.common.db.impl.FileConfigLoader;
import com.future.spring.rocket.common.db.impl.TomcatDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@ComponentScan
@Configuration
public class MainConfig {

    @Bean
    public DataSource dataSource() {
        ConfigLoader configLoader = new FileConfigLoader("db.properties");
        DataSourceFactory dataSourceFactory = new TomcatDataSourceFactory();
        DbUtil dbUtil = new DbUtil(configLoader, dataSourceFactory);
        return dbUtil.getDataSource();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public TransactionDefinition transactionDefinition() {
        return new DefaultTransactionDefinition();
    }

    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager platformTransactionManager, TransactionDefinition transactionDefinition) {
        return new TransactionTemplate(platformTransactionManager, transactionDefinition);
    }
}
