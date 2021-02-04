package com.hkk.boottest;

import com.hkk.boottest.config.ProfileConfig;
import com.hkk.boottest.spring.LogTest;
import com.hkk.boottest.spring.SayHello;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(ProfileConfig.class)
public class BootTestApplication {

    public static void main(String[] args) {
        System.out.println(BootTestApplication.class.getClassLoader().getParent());
        System.out.println(BootTestApplication.class.getClassLoader());
        ConfigurableApplicationContext applicationContext = SpringApplication
            .run(BootTestApplication.class, args);
        LogTest logTest = applicationContext.getBean(LogTest.class);
        logTest.logBefore();
        logTest.logAfter();
        System.out.println("=====");
        SayHello helloService = applicationContext.getBean(SayHello.class);
        helloService.sayHello();
    }

}
