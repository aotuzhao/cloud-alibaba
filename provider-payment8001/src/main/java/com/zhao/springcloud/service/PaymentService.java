package com.zhao.springcloud.service;

import com.zhao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/26 1:24 下午
 */
public interface PaymentService {
    int creat(Payment payment);

    Payment getById( Long id);
}
