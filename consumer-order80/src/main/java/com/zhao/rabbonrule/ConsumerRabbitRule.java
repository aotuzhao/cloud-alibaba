package com.zhao.rabbonrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 自定义负载均衡规则
 * @Author zhaoxuezhao
 * @Date 2021/1/27 3:54 下午
 */
@Configuration
public class ConsumerRabbitRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
