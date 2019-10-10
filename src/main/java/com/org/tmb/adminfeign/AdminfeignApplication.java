package com.org.tmb.adminfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AdminfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminfeignApplication.class, args);
    }

}
