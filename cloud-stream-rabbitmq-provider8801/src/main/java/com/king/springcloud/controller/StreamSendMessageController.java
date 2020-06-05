package com.king.springcloud.controller;

import com.king.springcloud.service.IMessageProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created by king on 2020/4/28 1:39 下午
 */
@RestController
public class StreamSendMessageController {

    @Resource
    private IMessageProviderService messageProviderService;

    @GetMapping(value = "/sendMsg")
    public String sendMsg(){
        return messageProviderService.send();
    }
}
