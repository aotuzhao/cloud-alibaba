package com.zhao.springcloud.controller;

import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/4 10:59 上午
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/nacos/getNo")
    public String getPayment() {
        return "nacos registry, serverPort: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
