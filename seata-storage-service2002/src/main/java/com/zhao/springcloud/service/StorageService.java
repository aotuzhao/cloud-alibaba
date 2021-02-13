package com.zhao.springcloud.service;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/12 10:56 下午
 */
public interface StorageService {
    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
