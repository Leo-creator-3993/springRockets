package com.future.spring.rocket.tx.order;

import com.future.spring.rocket.common.db.ConfigLoader;
import com.future.spring.rocket.common.db.DataSourceFactory;
import com.future.spring.rocket.common.db.DbUtil;
import com.future.spring.rocket.common.db.impl.FileConfigLoader;
import com.future.spring.rocket.common.db.impl.TomcatDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@EnableTransactionManagement(order = 2)
@EnableAspectJAutoProxy
public class MainConfig {

    @Bean
    public DataSource dataSource() {
        ConfigLoader configLoader = new FileConfigLoader("db.properties");
        DataSourceFactory dataSourceFactory = new TomcatDataSourceFactory();
        DbUtil dbUtil = new DbUtil(configLoader, dataSourceFactory);
        return dbUtil.getDataSource();
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
