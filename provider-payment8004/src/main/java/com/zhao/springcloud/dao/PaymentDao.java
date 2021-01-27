package com.zhao.springcloud.dao;

import com.zhao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/26 11:07 上午
 */
@Mapper
public interface PaymentDao {

    int creat(Payment payment);

    Payment getById(@Param("id") Long id);
}
