package com.king.springcloud.controller;

import com.king.springcloud.entities.CommonResult;
import com.king.springcloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created by king on 2020/4/15 5:22 下午
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping(value = "/order/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        return orderFeignService.get(id);
    }
}
