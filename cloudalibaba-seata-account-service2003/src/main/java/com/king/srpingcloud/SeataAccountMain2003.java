package com.king.srpingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * created by king on 2020/6/4 11:10 下午
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SeataAccountMain2003 {
    public static void main(String[] args) {
            SpringApplication.run(SeataAccountMain2003.class,args);
        }
}
