package com.servicebase.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: Uooc自定义全局异常处理类
 * @author: mark
 * @create: 2023-08-06 14:26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UoocException extends RuntimeException{
    //状态码
    private Integer code;
    //异常信息
    private String msg;

}

