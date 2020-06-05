package com.king.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created by king on 2020/4/16 11:16 上午
 */
@Configuration
public class OpenFeignLogConfig {

    @Bean
    Logger.Level feignLoggerLeave(){
        return Logger.Level.FULL;
    }
}
