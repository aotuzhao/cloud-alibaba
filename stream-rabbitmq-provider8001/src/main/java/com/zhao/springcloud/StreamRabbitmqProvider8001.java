package com.zhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/2 5:39 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitmqProvider8001 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqProvider8001.class,args);
    }
}
