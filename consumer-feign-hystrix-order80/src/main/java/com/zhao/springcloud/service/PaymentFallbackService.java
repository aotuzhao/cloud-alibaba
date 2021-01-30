package com.zhao.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/29 5:49 下午
 */
@Component
public class PaymentFallbackService implements PaymentHystrixFeignClient{
    @Override
    public String ok() {
        return "PaymentFallbackService-ok";
    }

    @Override
    public String timeout() {
        return "PaymentFallbackService-timeout";
    }

    @Override
    public String test(Integer id) {
        return "null";
    }
}
