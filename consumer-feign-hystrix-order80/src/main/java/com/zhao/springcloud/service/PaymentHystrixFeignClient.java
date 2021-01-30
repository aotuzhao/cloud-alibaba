package com.zhao.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/28 2:24 下午
 */
@Component
@FeignClient(value = "PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystrixFeignClient {

    @GetMapping("/payment/ok")
    public String ok();
    @GetMapping("/payment/timeOut")
    public String timeout();

    @GetMapping("/getById/{id}")
    public String test(@PathVariable("id") Integer id);
}
