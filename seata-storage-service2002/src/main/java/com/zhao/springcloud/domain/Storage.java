package com.zhao.springcloud.domain;

import lombok.Data;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/12 10:52 下午
 */

@Data
public class Storage {
    private Long id;

    /** 产品id
     *
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;


    /**
     * 已用库存
     */
    private Integer used;


    /**
     * 剩余库存
     */
    private Integer residue;
}
