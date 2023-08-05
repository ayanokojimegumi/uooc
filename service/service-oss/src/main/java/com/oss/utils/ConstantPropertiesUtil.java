package com.oss.utils;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description: 常量类，读取配置文件application.properties中的配置
 * @author: mark
 * @create: 2023-08-04 17:05
 **/

@Component
public class ConstantPropertiesUtil implements InitializingBean {
    @Schema(title = "地域节点(用于外网访问)")
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Schema(title = "凭证id")
    @Value("${aliyun.accessKeyId}")
    private String accessKeyId;

    @Schema(title = "凭证密码")
    @Value("${aliyun.accessKeySecret}")
    private String accessKeySecret;

    @Schema(title = "存储服务名称")
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    @Value("${aliyun.oss.urlPrefix}")
    private String urlPrefix;

    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;
    public static String URL_PREFIX;

    @Override
    public void afterPropertiesSet() {
        END_POINT = endpoint;
        ACCESS_KEY_ID = accessKeyId;
        ACCESS_KEY_SECRET = accessKeySecret;
        BUCKET_NAME = bucketName;
        URL_PREFIX = urlPrefix;
    }
}
