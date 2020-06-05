package com.king.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * created by king on 2020/4/13 3:41 下午
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
            SpringApplication.run(OrderMain80.class,args);
        }
}
