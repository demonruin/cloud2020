package com.king.springcloud.service.impl;

import com.king.springcloud.dao.PaymentDao;
import com.king.springcloud.entities.Payment;
import com.king.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * created by king on 2020/4/13 2:46 下午
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }
}
