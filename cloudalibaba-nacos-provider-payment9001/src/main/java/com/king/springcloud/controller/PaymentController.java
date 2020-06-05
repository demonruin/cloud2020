package com.king.springcloud.controller;

import com.king.springcloud.entities.CommonResult;
import com.king.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * created by king on 2020/5/8 12:38 下午
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/nacos/payment/{id}")
    public String getNacosPayment(@PathVariable("id") Integer id) {
        return "this is Nacos Payment Service id=\t" + id + "\t server port :\t" + serverPort;
    }

    /**
     * 此方法与接口是为了测试sentinel的fallback服务降级
     * @param id
     * @return
     */
    public static HashMap<Integer, Payment> hashMap = new HashMap();

    static {
        hashMap.put(1, new Payment(1L, "28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2, new Payment(2L, "bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3, new Payment(3L, "6ua8c1e3bc2742d8848569891xt92183"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Integer id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult(200, "from mysql,serverPort: " + serverPort, payment);
        return result;
    }


}
