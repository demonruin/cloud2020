package com.king.springcloud.contorller;

import com.king.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created by king on 2020/4/16 3:27 下午
 */
@RestController
@Slf4j
public class PaymentHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value="/payment/ok/{id}")
    public String getOk(@PathVariable("id") Integer id){
        String ok = paymentHystrixService.getOk(id);
        log.info(ok);
        return  ok;
    }

    @GetMapping(value="/payment/timeout/{id}")
    public String getTimeout(@PathVariable("id") Integer id){
        String timeout = paymentHystrixService.getTimeout(id);
        log.info(timeout);
        return  timeout;
    }
    @GetMapping(value="/payment/breaker/{id}")
    public String getBreaker(@PathVariable("id") Integer id){
        String breaker = paymentHystrixService.hystrixCircuitBreaker(id);
        log.info(breaker);
        return  breaker;
    }
}
