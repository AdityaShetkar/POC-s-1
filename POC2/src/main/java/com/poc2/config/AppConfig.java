package com.poc2.config;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    public void customize(ConfigurableServletWebServerFactory factory){
        factory.setPort(8080);
    }

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/poc");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root");
        return dataSourceBuilder.build();
    }

    @Bean
    public void printHikariConnectionDetails() {
        HikariDataSource ds = (HikariDataSource) getDataSource();
        System.err.println("Instance of DBCP basic data source: " + ds);
        System.err.println("Driver class name: " + ds.getDriverClassName());
        System.err.println("Connection Pool size : " + ds.getMaximumPoolSize());
        ds.setMaximumPoolSize(8);
        System.err.println("Connection After setting Pool size :" + ds.getMaximumPoolSize());
        System.err.println("Url: " + ds.getJdbcUrl());
    }

}