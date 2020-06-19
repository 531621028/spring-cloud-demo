package com.hkk.feignservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FeignProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(FeignProviderApplication.class, args);
    }

}
