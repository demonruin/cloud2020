package com.king.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * created by king on 2020/4/15 5:19 下午
 */
@SpringBootApplication
@EnableFeignClients
public class OrderOpenfeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenfeignMain80.class, args);
    }
}
