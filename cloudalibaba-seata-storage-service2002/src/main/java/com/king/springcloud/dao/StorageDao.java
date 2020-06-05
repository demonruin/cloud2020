package com.king.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * created by king on 2020/6/4 10:58 下午
 */
@Mapper
public interface StorageDao {
    //扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
