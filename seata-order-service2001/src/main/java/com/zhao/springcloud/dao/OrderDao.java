package com.zhao.springcloud.dao;

import com.zhao.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/12 9:44 下午
 */
@Mapper
public interface OrderDao {
    /**
     * 新建订单
     *
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态，从零改为1
     *
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
