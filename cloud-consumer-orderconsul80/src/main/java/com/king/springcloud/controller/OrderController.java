package com.king.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * created by king on 2020/4/15 9:58 上午
 */
@RestController
@Slf4j
public class OrderController {
    private static  final  String SERVICE_URL="http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value="/order/consul/getPayInfo")
    public String getPayInfo(){
        log.info("consul实现注册请求成功");
        String forObject = restTemplate.getForObject(SERVICE_URL + "/payment/consul", String.class);
        return forObject;
    }
}
