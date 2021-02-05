package com.zhao.springcloud.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/4 2:28 下午
 */
@RestController
@RequestMapping("/nacos")
@RefreshScope
public class ConfigClientController {


    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
