package com.zhao.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/9 4:05 下午
 */
public class CustomerBlockHandler {

    public static String handleException(BlockException exception) {
        return new String(" 自定义限流处理信息 ....CustomerBlockHandler");
    }

}
