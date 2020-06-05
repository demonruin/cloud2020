package com.king.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * created by king on 2020/5/8 4:07 下午
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("consumer/nacos/payment/{id}")
    public String getNacosPayment(@PathVariable("id") Integer id){
        return restTemplate.getForObject(serverUrl+"/nacos/payment/"+id,String.class);
    }
}
