package com.king.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.king.springcloud.dao"})
public class MyBatisConfig {
}