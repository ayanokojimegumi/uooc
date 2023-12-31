package com.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * OSS启动需要数据源，但是当前模块不需要连接数据库，所以使用exclude排除DataSource
 * OSS类的启动器
 *
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class OssApplication {
    public static void main( String[] args ) {
        SpringApplication.run(OssApplication.class, args);
    }
}
