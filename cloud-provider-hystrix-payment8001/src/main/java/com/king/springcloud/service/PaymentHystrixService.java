package com.king.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * created by king on 2020/4/16 3:22 下午
 */
@Service
public class PaymentHystrixService {

    /**
     * 成功访问
     *
     * @param id
     * @return
     */
    public String getOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " ID:" + id + "\t 访问成功";
    }

    /**
     * 访问超时
     *
     * @param id
     * @return 5000是指5s
     */
    @HystrixCommand(fallbackMethod = "paymentFallback_handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String getTimeout(Integer id) {
        int timeout = 3;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " ID:" + id + "\t 访问超时，超时时间(秒)：" + timeout;
    }

    public String paymentFallback_handler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentFallback_handler---ID:" + id + "\t ";
    }


    /**
     * 服务熔断 测试demo
     *
     */
    @HystrixCommand(fallbackMethod = "breakerFallback_handler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败率达到多少后跳闸
    })
    public String hystrixCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功，流水号：" + uuid;
    }

    public String breakerFallback_handler(Integer id) {
        return "id不能为负数，请稍后再试。。。。";
    }


}
