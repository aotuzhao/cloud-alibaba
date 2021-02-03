package com.zhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/3 1:03 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamConsumer8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumer8802.class,args);
    }
}
