package com.king.springcloud.controller;

import com.king.springcloud.domain.CommonResult;
import com.king.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created by king on 2020/6/4 10:50 下午
 */
@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;    //扣减库存

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功！");
    }
}
