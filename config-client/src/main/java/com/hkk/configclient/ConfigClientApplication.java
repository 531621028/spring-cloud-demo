package com.hkk.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext= SpringApplication.run(ConfigClientApplication.class, args);
        System.out.println(applicationContext.getEnvironment());
    }

}
