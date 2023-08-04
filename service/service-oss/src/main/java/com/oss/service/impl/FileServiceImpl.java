package com.oss.service.impl;

import com.oss.service.FileService;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description: 文件上传类，用于将图片上传到OSS
 * @author: mark
 * @create: 2023-08-04 17:18
 **/
public class FileServiceImpl implements FileService {
    /**
     * 文件上传至阿里云
     * @param file 文件对象
     * @return 返回string类型
     */
    @Override
    public String upload(MultipartFile file) {
        return null;
    }
}
