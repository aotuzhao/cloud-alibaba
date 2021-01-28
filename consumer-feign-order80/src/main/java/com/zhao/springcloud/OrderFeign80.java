package com.zhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/27 5:49 下午
 */
@EnableFeignClients
@SpringBootApplication
public class OrderFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeign80.class,args);
    }
}
