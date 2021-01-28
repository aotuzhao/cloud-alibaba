package com.zhao.springcloud.controller;

import com.zhao.springcloud.entities.CommentResult;
import com.zhao.springcloud.entities.Payment;
import com.zhao.springcloud.feign.PaymentFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/27 8:11 下午
 */
@RestController
public class OrderController {
    @Resource
    private PaymentFeignClient paymentFeignClient;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignClient.getById(id);
    }

    @GetMapping(value = "/consumer/timeout")
    public CommentResult<Payment> timeOut() {
        return paymentFeignClient.timeout();
    }
}
