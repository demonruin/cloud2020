package com.king.springcloud.service;

import com.king.springcloud.entities.CommonResult;
import com.king.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * created by king on 2020/5/29 1:30 下午
 */
@FeignClient(value = "nacos-provider-payment", fallback = PaymentServiceFallback.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
