package com.servicebase.exception;

/**
 * @description: 读取excel数据为空异常
 * @author: mark
 * @create: 2023-08-05 11:31
 **/
public class NotDataFormExcelException extends Exception{
    public NotDataFormExcelException() {
    }

    public NotDataFormExcelException(String message) {
        super(message);
    }

    public NotDataFormExcelException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotDataFormExcelException(Throwable cause) {
        super(cause);
    }

    public NotDataFormExcelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
