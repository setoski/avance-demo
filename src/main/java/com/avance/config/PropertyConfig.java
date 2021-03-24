package com.avance.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/application.yml")
public class PropertyConfig {

    @Value("spring.datasource.hikari.jdbc-url")
    private String jdbcUrl;
    @Value("spring.datasource.hikari.username")
    private String dbUsername;
    @Value("spring.datasource.hikari.password")
    private String dbPassword;
    @Value("spring.datasource.hikari.driver-class-name")
    private String driverClassName;
    @Value("spring.datasource.hikari.minimum-idle")
    private String minimumIdle;

    
    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getMinimumIdle() {
        return minimumIdle;
    }

    public void setMinimumIdle(String minimumIdle) {
        this.minimumIdle = minimumIdle;
    }
}