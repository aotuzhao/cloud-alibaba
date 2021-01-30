package com.zhao.springcloud.service;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhao.springcloud.entities.Payment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/26 1:24 下午
 */
@Component
public class PaymentService {
    @HystrixCommand
    public String ok() {
        return "payment-hystrix: " + Thread.currentThread().getName() + " \t ok  " + UUID.randomUUID().toString();
    }

    @HystrixCommand(fallbackMethod = "timoutFallbackHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String timeout() {
        try {
            TimeUnit.SECONDS.sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "payment-hystrix: " + Thread.currentThread().getName() + " \t timeout " + UUID.randomUUID().toString();
    }


    public String timoutFallbackHandler() {
        return Thread.currentThread().getName() + " 请稍后重试！";
    }

    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否 开启断 路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 请 求次 数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间 范 围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"), // 失 败 率 达 到多少后跳 闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id 不能负数 ");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + " \t " + " 调用成功 , 流水号： " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍候再试 ,(┬ ＿ ┬)/~~ id: " + id;
    }
}
