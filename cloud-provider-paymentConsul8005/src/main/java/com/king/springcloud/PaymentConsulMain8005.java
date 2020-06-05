package com.king.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * created by king on 2020/4/15 9:35 上午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8005.class, args);
    }
}
