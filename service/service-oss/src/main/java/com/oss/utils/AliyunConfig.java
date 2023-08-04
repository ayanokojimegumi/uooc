package com.oss.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @description: 常量类，读取配置文件application.properties中的配置
 * @author: mark
 * @create: 2023-08-04 17:05
 **/

@Data
@Configuration
public class AliyunConfig{
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

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public OSS ossClient() {
        OSS oss = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        oss.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
        return oss;
    }
}
