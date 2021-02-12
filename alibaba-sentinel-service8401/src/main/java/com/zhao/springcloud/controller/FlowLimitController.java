package com.zhao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zhao.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/5 3:50 下午
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1L);
        return "------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "hot_handler")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testB";
    }

    public String hot_handler(String p1, String p2) {
        return "hot_handler";
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public String byUrl() {
        return new String(" 按 url 限流测试 OK");
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public String customerBlockHandler() {
        return new String(" 按客戶自定义 ");
    }


}
