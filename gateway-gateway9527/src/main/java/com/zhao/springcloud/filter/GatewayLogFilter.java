package com.zhao.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/2/1 3:53 下午
 */
@Component
@Slf4j
public class GatewayLogFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*********come in MyLogGateWayFilter: " + LocalDateTime.now().toString());
        String uname = exchange.getRequest().getQueryParams().getFirst("username");
        if (StringUtils.isNotEmpty(uname)&&StringUtils.endsWithIgnoreCase(uname,"root")) {
            log.info("***** 用户名为 Null 非法用户 ,(┬ ＿ ┬)");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            // 给人家一 个 回 应
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

