package com.king.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * created by king on 2020/5/8 2:32 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderPaymentMain9002 {
    public static void main(String[] args) {
            SpringApplication.run(NacosProviderPaymentMain9002.class,args);
        }
}
