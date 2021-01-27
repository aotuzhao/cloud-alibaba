package com.zhao.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/27 5:06 下午
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
