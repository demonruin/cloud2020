package com.king.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * created by king on 2020/4/28 3:40 下午
 */
@Component
@EnableBinding(Sink.class)
public class StreamConsumerReceiveMessageListnerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("我是消费者1号，接收到的消息为：" + message.getPayload() + "\t 端口号为：" + serverPort);
    }
}
