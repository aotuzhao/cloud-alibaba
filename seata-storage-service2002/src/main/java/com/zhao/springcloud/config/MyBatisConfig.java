package com.zhao.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/12 10:14 下午
 */
@Configuration
@MapperScan({"com.zhao.springcloud.dao"})
public class MyBatisConfig {
}
