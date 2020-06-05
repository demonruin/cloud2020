package com.king.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * created by king on 2020/4/23 5:05 下午
 */
@Component
@Slf4j
public class MyLogGlobalFilter implements GlobalFilter, Ordered {

    /**
     * 1.先通过exchange获取参数
     * 2.验证参数是否合法
     *      参数不合法：通过exchange的response设置状态码，然后响应出去
     * 3.完成操作后通过 chain.filter(exchange)过滤链 传递下去
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*********come in MyLogGlobalFilter: "+new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname ==null){
            log.info("uname 为空，非法用户，请出去~~~~");
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return  response.setComplete();
        }
        return chain.filter(exchange);
    }

    //加载过滤器的顺序，一般数字越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
