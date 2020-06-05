package com.king.springcloud.controller;

import com.king.springcloud.service.OrderFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created by king on 2020/4/16 5:43 下午
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "globle_fallbackHystrix_handler")
public class OrderFeignHystrixController {
    @Resource
    private OrderFeignHystrixService orderFeignHystrixService;

    @GetMapping(value = "/payment/ok/{id}")
    @HystrixCommand
    public String getOK(@PathVariable("id") Integer id) {
        return orderFeignHystrixService.getOk(id);
    }

    @GetMapping(value = "/payment/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "fallbackHystrix_handler_order",
//            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
    public String getTimeout(@PathVariable("id") Integer id) {
        return orderFeignHystrixService.getTimeout(id);
    }

    public String fallbackHystrix_handler_order(@PathVariable("id") Integer id){
        return "80请求服务失败";
    }

    public String globle_fallbackHystrix_handler(){
        return "请求服务失败，返回全局服务降级处理方法";
    }
}
