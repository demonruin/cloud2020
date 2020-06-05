package com.king.springcloud.controller;

import com.king.springcloud.entities.CommonResult;
import com.king.springcloud.entities.Payment;
import com.king.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * created by king on 2020/4/13 2:48 下午
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Payment result = paymentService.getPaymentById(id);
        log.info("*****查询结果：" + result + "/hahahhaha");
        if (result != null) {
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "没有对应的记录：ID=" + id, result);
        }
    }

    @GetMapping(value = "/getDiscovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("***element:" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PANMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("****insatance:" + instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }


    @GetMapping(value = "/payment/lb")
    public Object lb() {
        return serverPort;
    }

    @GetMapping(value = "/payment/zipkin")
    public Object zipkin() {
        return "zipkin 测试链路请求返回值加端口号："+serverPort;
    }


}
