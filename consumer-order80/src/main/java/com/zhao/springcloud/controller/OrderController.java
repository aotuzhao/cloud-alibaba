package com.zhao.springcloud.controller;

import com.zhao.springcloud.entities.CommentResult;
import com.zhao.springcloud.entities.Payment;
import com.zhao.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/26 11:11 上午
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderController {


    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment";

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancer loadBalancer;
    @PostMapping("/creat")
    public CommentResult<Integer> creat(@RequestBody Payment payment) {
        log.info("OrderController-creat-start-{}", payment, CommentResult.class);
        CommentResult commentResult = restTemplate.postForObject(PAYMENT_URL + "/creat", payment, CommentResult.class);
        log.info("OrderController-creat-end-{}", commentResult);
        return commentResult;
    }

    @GetMapping("/getById/{id}")
    public CommentResult<Payment> getById(@PathVariable("id") Long id) {
        log.info("OrderController-getById-start-{}", id);
        CommentResult commentResult = restTemplate.getForObject(PAYMENT_URL + "/getById/" + id, CommentResult.class);
        log.info("OrderController-getById-end-{}", commentResult);
        return commentResult;
    }

    @GetMapping("/getById/loadBalancer/{id}")
    public CommentResult<Payment> loadBalancerTest(@PathVariable("id") Long id) {
        log.info("OrderController-getById-start-{}", id);
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instances1 = loadBalancer.instances(instances);
        CommentResult commentResult = restTemplate.getForObject(instances1.getUri() + "/getById/" + id, CommentResult.class);
        log.info("OrderController-getById-end-{}", commentResult);
        return commentResult;
    }
}

