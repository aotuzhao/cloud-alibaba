package com.zhao.springcloud.feign;

import com.zhao.springcloud.entities.CommentResult;
import com.zhao.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/27 7:01 下午
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignClient {

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/getById/{id}")
    CommentResult<Payment> getById(@PathVariable("id") Long id);


    @GetMapping( value ="/payment/timeout" )
    public CommentResult timeout() ;
}
