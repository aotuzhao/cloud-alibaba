package com.zhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/5 3:49 下午
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Sentinel8401 {
    public static void main(String[] args) {
        SpringApplication.run(Sentinel8401.class,args);
    }
}
