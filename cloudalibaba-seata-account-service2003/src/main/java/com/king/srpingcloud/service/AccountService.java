package com.king.srpingcloud.service;

import java.math.BigDecimal;

/**
 * created by king on 2020/6/4 11:15 下午
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
