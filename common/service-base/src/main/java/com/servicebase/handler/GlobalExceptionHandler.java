package com.servicebase.handler;

import com.commonutils.R;
import com.servicebase.exception.ImageTypeException;
import com.servicebase.exception.NotDataFormExcelException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error();
    }

    @ExceptionHandler(ImageTypeException.class)
    @ResponseBody
    public R error(ImageTypeException e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error();
    }
    @ExceptionHandler(NotDataFormExcelException.class)
    @ResponseBody
    public R error(NotDataFormExcelException e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error();
    }
}
