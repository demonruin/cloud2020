package com.king.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * created by king on 2020/6/3 10:39 下午
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SeataOrderMain2001 {
    public static void main(String[] args) {
            SpringApplication.run(SeataOrderMain2001.class,args);
        }
}
