package com.zhao.springcloud.controller;

import com.zhao.springcloud.domain.CommonResult;
import com.zhao.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/12 10:59 下午
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;


    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功！");
    }
}
