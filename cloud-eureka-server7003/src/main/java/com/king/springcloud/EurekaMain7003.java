package com.king.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * created by king on 2020/4/13 5:47 下午
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7003 {
    public static void main(String[] args) {
            SpringApplication.run(EurekaMain7003.class,args);
        }
}
