package com.king.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * created by king on 2020/4/16 5:40 下午
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE-HYSTRIX",fallback = FallbackServiceHandler.class)
public interface OrderFeignHystrixService {


    @GetMapping(value = "/payment/ok/{id}")
    public String getOk(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/timeout/{id}")
    public String getTimeout(@PathVariable("id") Integer id);
}
