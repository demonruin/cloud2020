package com.king.springcloud.dao;

import com.king.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * created by king on 2020/4/13 2:16 下午
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}
