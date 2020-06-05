package com.king.springcloud.service;

import com.king.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * created by king on 2020/4/15 5:20 下午
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id);
}
