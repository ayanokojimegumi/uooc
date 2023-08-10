package com.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Edu服务启动类
 *
 */
@SpringBootApplication
@EnableDiscoveryClient  //nacos注册
@EnableFeignClients //开启服务调用
public class EduApplication {
    public static void main( String[] args ) {
        SpringApplication.run(EduApplication.class, args);
    }
}
