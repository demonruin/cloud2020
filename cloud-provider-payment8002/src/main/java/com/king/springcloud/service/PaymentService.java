package com.king.springcloud.service;

import com.king.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * created by king on 2020/4/13 2:45 下午
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}
