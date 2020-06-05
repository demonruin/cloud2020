package com.king.springcloud.service;

import com.king.springcloud.entities.CommonResult;
import com.king.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * created by king on 2020/5/29 1:33 下午
 */
@Component
public class PaymentServiceFallback implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
