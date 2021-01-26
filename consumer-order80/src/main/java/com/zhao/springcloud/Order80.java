package com.zhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/26 2:29 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class Order80 {
    public static void main(String[] args) {
        SpringApplication.run(Order80.class,args);
    }


}
