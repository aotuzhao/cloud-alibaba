package com.zhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/4 11:16 上午
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosPayment9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPayment9002.class, args);
    }
}
