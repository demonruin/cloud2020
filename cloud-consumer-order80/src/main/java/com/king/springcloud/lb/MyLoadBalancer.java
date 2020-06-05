package com.king.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * created by king on 2020/4/15 2:15 下午
 */
public interface MyLoadBalancer {
    //收集服务器总共有多少台能够提供服务的机器，并放到list里面
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
