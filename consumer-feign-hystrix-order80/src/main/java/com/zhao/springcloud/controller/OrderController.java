package com.zhao.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhao.springcloud.service.PaymentHystrixFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/27 2:47 下午
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallbackHandler")
public class OrderController {

    @Autowired
    private PaymentHystrixFeignClient paymentService;

    @GetMapping( "/consumer/ok")
    @HystrixCommand()
    public String ok() {
        String ok = paymentService.ok();
        log.info(ok);
        return ok;
    }

    @GetMapping("/consumer/timeOut")
    @HystrixCommand(fallbackMethod = "timoutFallbackHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public String timeout(){
        String timeout = paymentService.timeout();
        log.info(timeout);
        return timeout;
    }

    public String  timoutFallbackHandler(){
        return Thread.currentThread().getName()+" 请稍后重试！";
    }

    public String  defaultFallbackHandler(){
        return Thread.currentThread().getName()+" 请稍后重试！";
    }
}
