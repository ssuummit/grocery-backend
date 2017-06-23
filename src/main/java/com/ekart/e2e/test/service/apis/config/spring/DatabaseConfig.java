package com.ekart.e2e.test.service.apis.config.spring;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * Created by sumit.nagariya on 14/06/16.
 */
@Configuration
@Import({ EnvironmentConfig.class,  HibernateConfig.class })
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.flipkart.rally.service.daos")
public class DatabaseConfig {

    @Inject
    private EnvironmentConfig environmentConfig;


    @Inject
    private HibernateConfig hibernateConfig;

    @Value("${database.packagesToScan}")
    private String packagesToScan;

    @Bean
    public HikariDataSource mysqlDataSource() {

        HikariDataSource dataSource = new HikariDataSource(hikariConfig());

        // https://github.com/brettwooldridge/HikariCP/wiki/Dropwizard-Metrics
        dataSource.setMetricRegistry(environmentConfig.metricRegistry());

        return dataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "database.hikari")
    public HikariConfig hikariConfig() {

        return new HikariConfig();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(mysqlDataSource());
        entityManagerFactoryBean.setPackagesToScan(new String[] { packagesToScan });
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPersistenceUnitName("mysqlPersistenceUnit");

        Properties hibernateProperties = new Properties();
        hibernateProperties.putAll(hibernateConfig.getHibernateProperties());
        entityManagerFactoryBean.setJpaProperties(hibernateProperties);

        return entityManagerFactoryBean;
    }

    @Bean
    @Primary
    public JpaTransactionManager transactionManager() throws PropertyVetoException {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {

        return new PersistenceExceptionTranslationPostProcessor();
    }
}
