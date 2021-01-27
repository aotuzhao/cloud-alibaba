package com.zhao.springcloud.controller;

import com.zhao.springcloud.entities.CommentResult;
import com.zhao.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/26 11:11 上午
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderController {


    public static final String PAYMENT_URL = "http://cloud-consul-payment/payment";

    @Resource
    private RestTemplate restTemplate;



    @GetMapping("/test")
    public CommentResult<String> getById() {
        log.info("OrderController-consul-getById-start-{}");
        CommentResult commentResult = restTemplate.getForObject(PAYMENT_URL + "/consul", CommentResult.class);
        log.info("OrderController-consul-getById-end-{}", commentResult);
        return commentResult;
    }

}
