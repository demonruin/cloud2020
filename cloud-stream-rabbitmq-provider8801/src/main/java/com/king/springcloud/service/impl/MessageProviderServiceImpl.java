package com.king.springcloud.service.impl;

import com.king.springcloud.service.IMessageProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * created by king on 2020/4/28 1:23 下午
 */
@EnableBinding(Source.class)//定义消息的推送管道
@Slf4j
public class MessageProviderServiceImpl implements IMessageProviderService {
    @Resource
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("*******serial:"+serial);
    return null;
    }
}
