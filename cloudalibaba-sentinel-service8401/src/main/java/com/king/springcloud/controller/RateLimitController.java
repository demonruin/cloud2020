package com.king.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.king.springcloud.entities.CommonResult;
import com.king.springcloud.myHandler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by king on 2020/5/28 5:52 下午
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/rateLimit/myLockHandler")
    @SentinelResource(value = "myLockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "dealLockHandlerException2")
    public CommonResult myLockHandler(){
        return new CommonResult(200,"myLockHandler方法进入成功");
    }
}
