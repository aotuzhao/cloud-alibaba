package com.zhao.springcloud.controller;

import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/4 11:41 上午
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

    @Resource
    private RestTemplate template;

    @Value("${service-url.payment-nacos-provider}")
    private String paymentServiceUrl;

    @GetMapping(value = "/nacos/getNo")
    public String getPayment() {
        return template.getForObject(paymentServiceUrl+"/payment/nacos/getNo",String.class);
    }
}
