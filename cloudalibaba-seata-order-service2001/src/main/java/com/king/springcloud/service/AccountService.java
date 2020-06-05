package com.king.springcloud.service;

import com.king.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * created by king on 2020/6/3 11:01 下午
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "account/decrease")
    CommonResult decreaseAccount(@RequestParam(value="userId") Long userId, @RequestParam(value="money") BigDecimal money);
}
