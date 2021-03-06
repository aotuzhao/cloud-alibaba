package com.zhao.springcloud.controller;

import com.zhao.springcloud.entities.CommentResult;
import com.zhao.springcloud.entities.Payment;
import com.zhao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/26 11:11 上午
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/creat")
    public CommentResult<Integer> creat(@RequestBody Payment payment) {
        log.info("creat-{}-start-{}",serverPort,payment);
        int creat = paymentService.creat(payment);
        CommentResult.CommentResultBuilder<Integer> builder = CommentResult.builder();
        builder.code(creat != 0 ? 200 : -1);
        builder.message(serverPort);
        builder.data(creat);
        log.info("creat-{}-end-{}",serverPort,creat);
        return builder.build();
    }

    @GetMapping("/getById/{id}")
    public CommentResult<Payment> getById(@PathVariable("id") Long id) {
        log.info("getById-{}-start-{}",serverPort,id);
        CommentResult.CommentResultBuilder<Payment> builder = CommentResult.builder();
        Payment payment = paymentService.getById(id);
        builder.code(200);
        builder.message(serverPort);
        builder.data(payment);
        log.info("getById-{}-end-{}",serverPort,payment);
        return builder.build();
    }

}
