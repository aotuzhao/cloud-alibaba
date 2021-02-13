package com.zhao.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/12 10:53 下午
 */
@Mapper
public interface StorageDao {
    /**
     * 扣减库存信息
     */

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
