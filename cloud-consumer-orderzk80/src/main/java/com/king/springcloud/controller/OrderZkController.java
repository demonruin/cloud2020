package com.king.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * created by king on 2020/4/14 2:58 下午
 */
@RestController
@Slf4j
public class OrderZkController {
    private static final String SERVICE_URL="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value="/order/getPayment/zk")
    public String getPaymentInfo (){
        return restTemplate.getForObject(SERVICE_URL+"/payment/zk",String.class);
    }
}
