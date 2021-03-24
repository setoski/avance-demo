package com.avance.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
    private PropertyConfig propsConfig;

    public DatabaseConfig(PropertyConfig propsConfig) {
        this.propsConfig = propsConfig;
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setPackagesToScan("com.avance.model");
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager platformTransactionMgr() {
        HibernateTransactionManager hibernateTransactionMgr = new HibernateTransactionManager();
        hibernateTransactionMgr.setSessionFactory(sessionFactory().getObject());
        return hibernateTransactionMgr;
    }

    @Bean
    public HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDataSourceProperties(hibernateProperties());
        config.setJdbcUrl("jdbc:mysql://localhost:3306/avance");
        config.setUsername("root");
        config.setPassword("olumide22");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setMinimumIdle(Runtime.getRuntime().availableProcessors());
        return new HikariDataSource(config);
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
        properties.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty(AvailableSettings.SHOW_SQL, "true");
        return properties;
    }
}
