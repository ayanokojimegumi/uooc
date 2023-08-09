package com.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Edu服务启动类
 *
 */
@SpringBootApplication
public class EduApplication {
    public static void main( String[] args ) {
        SpringApplication.run(EduApplication.class, args);
    }
}
