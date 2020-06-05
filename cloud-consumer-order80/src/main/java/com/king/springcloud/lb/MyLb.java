package com.king.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by king on 2020/4/15 2:19 下午
 * 为了防止restTemplate中的@loadbalance注解影响，所以自定义负载均衡算法的时候，会将那个注解注释掉
 * 此为自定义LoadBalancer
 */
@Component
public class MyLb implements MyLoadBalancer {
    //定义原子类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //通过自旋锁，cas，得到第几次访问次数
    private final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("***第几次访问，访问次数："+next);
        return next;
    }

    //负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下表，每次服务重启后rest接口计数从1开始
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
