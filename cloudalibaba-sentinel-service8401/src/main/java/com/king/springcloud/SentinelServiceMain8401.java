package com.king.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * created by king on 2020/5/26 3:46 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceMain8401 {
    public static void main(String[] args) {
            SpringApplication.run(SentinelServiceMain8401.class,args);
        }
}
