package com.king.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * created by king on 2020/4/15 9:36 上午
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value="/payment/consul")
    public String paymentConsul(){
        log.info("**************tretetetetet");
        return "springboot with consul serverPort:"+serverPort+"\t" + UUID.randomUUID().toString();
    }

}
