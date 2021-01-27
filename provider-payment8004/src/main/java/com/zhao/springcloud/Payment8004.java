package com.zhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/26 11:43 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8004 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004.class,args);
    }
}
