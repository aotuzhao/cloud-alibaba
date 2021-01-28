package com.zhao.springcloud.config;

import feign.Logger;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/28 9:26 上午
 */
@Configuration
public class FeignConfiguration {


    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
