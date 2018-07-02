package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Primary
    @Bean("readDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource readDataSource(){
       return DataSourceBuilder.create().build();
    }
    @Bean("writeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource writeDataSource(){
        return DataSourceBuilder.create().build();
    }
}
