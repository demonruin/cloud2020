package com.king.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created by king on 2020/4/23 2:21 下午
 * 配置了一个id为myroutebaidu1的路由规则，
 * 当访问地址http://localhost:9527/guone时会自动转发到地址: http://news.baidu.com/guonei
 */
@Configuration
public class GatewayConfiguration {
    @Bean
    public RouteLocator customerRouterLocator1(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("myroutebaidu1", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
    @Bean
    public RouteLocator customerRouterLocator2(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("myroutebaidu2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
    //注意：此处的path需要和uri的最后路径保持一致，不一致会报错找不到的，这个game就是反例~~
    @Bean
    public RouteLocator customerRouterLocator3(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("myroutebaidu3", r -> r.path("/mygame").uri("http://news.baidu.com/game")).build();
        return routes.build();
    }
}
