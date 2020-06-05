package com.king.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * created by king on 2020/4/17 1:31 下午
 */
@Component
public class FallbackServiceHandler implements OrderFeignHystrixService {

    public String getOk(Integer id) {
        return "getOk的统一fallback";
    }

    public String getTimeout(Integer id) {
        return "getTimeout的统一fallback";
    }
}
