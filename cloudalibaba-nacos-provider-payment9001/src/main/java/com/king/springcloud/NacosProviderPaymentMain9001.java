package com.king.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * created by king on 2020/5/8 12:08 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderPaymentMain9001 {
    public static void main(String[] args) {
            SpringApplication.run(NacosProviderPaymentMain9001.class,args);
        }
}
