package com.king.springcloud.controller;

import com.king.springcloud.lb.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * created by king on 2020/4/15 2:34 下午
 */
@RestController
@Slf4j
public class LbController {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private MyLoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;


    //此处lb接口能成功是因为将 applicationContextConfig中的restemplate的@Loadbalance注解注释掉了，所以两个controller中只有一个能成功~想切换到
    //到此处成功，就将那个@Loadbalance注解注释掉
    @GetMapping(value="/consumer/getLb")
    public String getLb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances==null || instances.size()==0){
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb/",String.class);
    }
}
