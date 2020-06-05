package com.king.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by king on 2020/6/4 10:53 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    private Long id;    // 产品id
    private Long productId;    //总库存
    private Integer total;     //已用库存
    private Integer used;      //剩余库存
    private Integer residue;
}
