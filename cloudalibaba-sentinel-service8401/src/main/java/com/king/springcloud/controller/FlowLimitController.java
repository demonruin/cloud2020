package com.king.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * created by king on 2020/5/26 3:48 下午
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName() + "\t" + "...testD 测试RT");
        return "------testD 测试RT";
    }

    @GetMapping("/testF")
    public String testF() {
        log.info(Thread.currentThread().getName() + "\t" + "...testF 测试 异常比例");
        int i = 10 / 0;
        return "------testF 测试 异常比例";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info(Thread.currentThread().getName() + "\t" + "...testE 测试 异常数");
        int i = 10 / 0;
        return "------testE 测试 异常数";
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "testHotKey~~~~";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "deal_testHotKey！！~~~(*￣︶￣)";// sentinel系统默认的提示: Blocked by Sentinel( flow limiting）
    }


}
