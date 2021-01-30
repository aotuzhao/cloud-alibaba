package com.zhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/28 2:20 下午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class OrderFeignHystrixOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixOrder80.class,args);
    }
}
