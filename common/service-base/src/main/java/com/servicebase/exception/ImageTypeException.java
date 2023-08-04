package com.servicebase.exception;

/**
 * @description: 图片类型异常类
 * @author: mark
 * @create: 2023-08-04 20:33
 **/
public class ImageTypeException extends Exception{
    public ImageTypeException() {
    }

    public ImageTypeException(String message) {
        super(message);
    }

    public ImageTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImageTypeException(Throwable cause) {
        super(cause);
    }

    public ImageTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
