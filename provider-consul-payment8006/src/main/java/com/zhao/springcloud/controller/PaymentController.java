package com.zhao.springcloud.controller;

import cn.hutool.core.lang.UUID;
import com.zhao.springcloud.entities.CommentResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/27 2:47 下午
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping( value ="/payment/consul" )
    public CommentResult test() {
        CommentResult commentResult = CommentResult.builder().code(200).message("success").data("springcloud with consul: " + serverPort + " \t " + UUID.randomUUID().toString()).build();
        return commentResult;
    }
}
