package com.zhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/4 10:58 上午
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosPayment9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPayment9001.class, args);
    }
}
