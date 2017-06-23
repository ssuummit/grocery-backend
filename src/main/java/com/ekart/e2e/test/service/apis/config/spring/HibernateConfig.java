package com.ekart.e2e.test.service.apis.config.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Created by sumit.nagariya on 14/06/16.
 */
@Configuration
@ConfigurationProperties(prefix = "database")
public class HibernateConfig {

    // Idea taken from
    // http://stackoverflow.com/questions/26580948/spring-boot-inject-mapenum-class-from-application-yml

    private Map<String, String> hibernateProperties;

    public Map<String, String> getHibernateProperties() {

        return hibernateProperties;
    }

    public void setHibernateProperties(Map<String, String> hibernateProperties) {

        this.hibernateProperties = hibernateProperties;
    }

    @Override
    public String toString() {

        return "HibernateProperties [hibernateProperties=" + hibernateProperties + "]";
    }
}