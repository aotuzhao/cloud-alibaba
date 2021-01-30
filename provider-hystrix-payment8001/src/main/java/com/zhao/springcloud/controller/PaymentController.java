package com.zhao.springcloud.controller;

import com.zhao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/27 2:47 下午
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/payment/ok")
    public String ok() {
        String ok = paymentService.ok();
        log.info(ok);
        return ok;
    }

    @GetMapping(value = "/payment/timeOut")
    public String timeOut() {
        String timeout = paymentService.timeout();
        log.info(timeout);
        return timeout;
    }

    @GetMapping("/getById/{id}")
    public String test(@PathVariable("id") Integer id){
        String s = paymentService.paymentCircuitBreaker(id);
        log.info(s);
        return s;
    }

}
