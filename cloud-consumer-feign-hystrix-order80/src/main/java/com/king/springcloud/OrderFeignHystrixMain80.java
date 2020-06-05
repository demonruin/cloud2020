package com.king.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * created by king on 2020/4/16 5:39 下午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class OrderFeignHystrixMain80 {
    public static void main(String[] args) {

            SpringApplication.run(OrderFeignHystrixMain80.class,args);
        }
}
