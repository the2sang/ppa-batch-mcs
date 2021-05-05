package com.kepco.ppa.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Primary
    @Bean(name = "etaxdatasource")
    @ConfigurationProperties(prefix = "spring.datasource1")
    public DataSource etaxdatasource(){
        return DataSourceBuilder.create()
        .driverClassName(env.getProperty("spring.datasource1.driverClassName"))
        .url(env.getProperty("spring.datasource1.url"))
        .username(env.getProperty("spring.datasource1.username"))
        .password(env.getProperty("spring.datasource1.password"))
        .build();
    }

    @Bean(name = "exedidatasource")
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource exedidatasource(){
        return DataSourceBuilder.create()
        .driverClassName(env.getProperty("spring.datasource2.driverClassName"))
        .url(env.getProperty("spring.datasource2.url"))
        .username(env.getProperty("spring.datasource2.username"))
        .password(env.getProperty("spring.datasource2.password"))
        .build();
    }
}
