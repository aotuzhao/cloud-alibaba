package com.zhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/2 7:23 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamConsumer8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumer8801.class,args);
    }
}
