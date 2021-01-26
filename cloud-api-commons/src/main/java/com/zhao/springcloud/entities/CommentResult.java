package com.zhao.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/26 1:29 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentResult<T> {

    private Integer code;
    private String message;
    private T data;


}
