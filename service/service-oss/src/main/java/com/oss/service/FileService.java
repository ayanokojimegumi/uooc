package com.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @description: 文件上传接口，用于上传图片到OSS中
 * @author: mark
 * @create: 2023-08-04 17:17
 **/
public interface FileService {
    /**
     * 文件上传至阿里云
     * @param file 文件对象
     * @return 返回string类型
     */
    String upload(MultipartFile file);
}
