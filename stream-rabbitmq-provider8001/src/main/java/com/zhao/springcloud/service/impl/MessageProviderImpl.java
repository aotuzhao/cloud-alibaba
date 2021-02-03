package com.zhao.springcloud.service.impl;

import com.zhao.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/2 5:59 下午
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String id = UUID.randomUUID().toString();
        boolean send = output.send(MessageBuilder.withPayload(id).build());
        log.info("{}-{}",id,send);
        return id+"-"+send;
    }
}
