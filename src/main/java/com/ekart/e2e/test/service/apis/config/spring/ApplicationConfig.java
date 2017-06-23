package com.ekart.e2e.test.service.apis.config.spring;

import com.ekart.e2e.test.service.service.BillServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan({ "com.ekart.e2e.test.service.apis" })
@Import({ EnvironmentConfig.class})
public class ApplicationConfig {

   // Reference:
   // http://docs.spring.io/spring-javaconfig/docs/1.0.0.M4/reference/html/ch04s02.html
   //Add your configs here

    @Bean
    public BillServiceImpl createBillService(){
        return new BillServiceImpl();
    }


}
