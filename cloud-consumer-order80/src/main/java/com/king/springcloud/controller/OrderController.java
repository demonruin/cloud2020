package com.king.springcloud.controller;

import com.king.springcloud.entities.CommonResult;
import com.king.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * created by king on 2020/4/13 3:53 下午
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL_PRE = "http://CLOUD-PAYMENT-SERVICE/";
    //    private static final String PAYMENT_URL_PRE="http://localhost:8001/";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create/")
    public CommonResult<Payment> create(Payment payment) {
        log.info(payment.toString());
        return restTemplate.postForObject(PAYMENT_URL_PRE + "/payment/create/", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL_PRE + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL_PRE + "/payment/get/" + id, CommonResult.class);
        log.info("forEntity实体内容：" + forEntity.toString());
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult<Payment>(444, "请求失败");
        }
    }

    @GetMapping(value = "/consumer/payment/zipkin")
    public Object getPaymentZipkin() {
        String forObject = restTemplate.getForObject(PAYMENT_URL_PRE + "/payment/zipkin/", String.class);
        log.info("forObject内容：" + forObject.toString());
        return forObject;
    }


}
