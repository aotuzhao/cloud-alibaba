package com.zhao.springcloud.controller;

import com.zhao.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/2 6:30 下午
 */
@RestController
@RequestMapping("/stream")
public class MessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public String send(){
        return messageProvider.send();
    }
}
