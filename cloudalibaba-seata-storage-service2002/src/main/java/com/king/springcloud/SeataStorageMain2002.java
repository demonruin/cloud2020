package com.king.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * created by king on 2020/6/4 10:49 下午
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SeataStorageMain2002 {
    public static void main(String[] args) {
            SpringApplication.run(SeataStorageMain2002.class,args);
        }
}
