package com.king.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * created by king on 2020/5/8 4:01 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumerOrderMain83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerOrderMain83.class, args);
    }
}
