package com.king.srpingcloud.controller;

import com.king.srpingcloud.domain.CommonResult;
import com.king.srpingcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * created by king on 2020/6/4 11:17 下午
 */
@RestController
@Slf4j
public class AccountController {
    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam(value="userId") Long userId, @RequestParam(value="money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减账户余额成功！");
    }
}
