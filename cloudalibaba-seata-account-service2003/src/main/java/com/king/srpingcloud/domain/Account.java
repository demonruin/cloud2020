package com.king.srpingcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * created by king on 2020/6/4 11:11 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 总额度
     */
    private BigDecimal total;
    /**
     * 已用额度
     */
    private BigDecimal used;
    /**
     * 剩余额度
     */
    private BigDecimal residue;
}
