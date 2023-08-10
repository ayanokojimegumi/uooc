package com.vod.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description: 视频上传常量类，定义了阿里云的访问id和秘钥
 * @author: mark
 * @create: 2023-08-10 15:55
 **/
@Component
public class ConstantPropertiesUtil implements InitializingBean {
    @Value("${aliyun.vod.file.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.vod.file.accessKeySecret}")
    private String accessKeySecret;

    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    @Override
    public void afterPropertiesSet() {
        ACCESS_KEY_ID = this.accessKeyId;
        ACCESS_KEY_SECRET = this.accessKeySecret;
    }
}
