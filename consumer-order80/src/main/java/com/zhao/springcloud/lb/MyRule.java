package com.zhao.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/27 5:07 下午
 */
@Component
public class MyRule implements LoadBalancer {

private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final Integer getNextIndex(){
        int current ,next;
        do {
            current = this.atomicInteger.get();
            next = current>=Integer.MAX_VALUE?0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        return serviceInstanceList.get(serviceInstanceList.size()%getNextIndex());
    }
}
