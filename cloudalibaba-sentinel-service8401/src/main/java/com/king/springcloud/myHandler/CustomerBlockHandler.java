package com.king.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.king.springcloud.entities.CommonResult;

/**
 * created by king on 2020/5/28 5:56 下午
 */
public class CustomerBlockHandler {

    public static CommonResult dealLockHandlerException1(BlockException exception){
        return new CommonResult(1111,"自定义处理兜底方法-------1");
    }
   public static CommonResult dealLockHandlerException2(BlockException exception){
        return new CommonResult(2222,"自定义处理兜底方法-------2");
    }
}
