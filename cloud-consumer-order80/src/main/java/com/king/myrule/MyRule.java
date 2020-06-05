package com.king.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created by king on 2020/4/15 10:56 上午
 */
@Configuration
public class MyRule {
    @Bean
    public IRule getMyRule(){
        return  new RandomRule();
    }
}
