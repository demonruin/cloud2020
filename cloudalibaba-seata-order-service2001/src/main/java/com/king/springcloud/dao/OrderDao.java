package com.king.springcloud.dao;

import com.king.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * created by king on 2020/6/3 10:51 下午
 */
@Mapper
public interface OrderDao {
    //1、创建订单
    void create (Order order);
    //2、更新订单状态，从0改为1
    void update (@Param("userId") Long userId, @Param("status") Integer status);

}
