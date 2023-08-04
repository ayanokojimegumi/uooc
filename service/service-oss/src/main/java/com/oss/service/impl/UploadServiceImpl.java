package com.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.oss.service.UploadService;
import com.oss.utils.AliyunConfig;
import com.servicebase.exception.ImageTypeException;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description: 文件上传类，用于将图片上传到OSS
 * @author: mark
 * @create: 2023-08-04 17:18
 **/
@Service
public class UploadServiceImpl implements UploadService {
    // 允许上传的格式
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".gif", ".png", ".webp"};
    @Resource
    private OSS ossClient;
    @Resource
    private AliyunConfig aliyunConfig;
    /**
     * 将上传的图片存储到阿里云OSS里
     * @param file 图片对象
     * @return 返回图片在OSS里的URL地址
     */
    @Override
    public String upload(MultipartFile file) throws ImageTypeException {
        if (!isLegal(file)) {
            throw new ImageTypeException("图片类型异常");
        }
        //定义返回的URL变量
        String url;
        //获取文件路径
        String filename = file.getOriginalFilename();
        //设置URL
        String filePath = this.getFilePath(filename);
        url =  aliyunConfig.getUrlPrefix() + filePath;

        InputStream inputStream;
        try {
            //通过file对象获取输入流
            inputStream = file.getInputStream();
            //上传至阿里OSS
            ossClient.putObject(aliyunConfig.getBucketName(), filePath, inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return url;
    }
    /**
     * 上传的目录
     * 目录: 根据年月日归档
     * 文件名: 时间戳 + 随机数
     * @param fileName 文件原名称
     * @return 返回一个由时间戳和随机数组成的文件名
     */
    private String getFilePath(String fileName) {
        DateTime dateTime = new DateTime();
        return "images/" + dateTime.toString("yyyy") + "/" + dateTime.toString("MM") + "/"
                + dateTime.toString("dd") + "/" + System.currentTimeMillis() +
                RandomUtils.nextInt(100, 9999) + "." + StringUtils.substringAfterLast(fileName, ".");
    }

    private boolean isLegal(MultipartFile file) {
        // 1. 对上传的图片进行校验: 这里简单校验后缀名
        // 另外可通过ImageIO读取图片的长宽来判断是否是图片,校验图片的大小等。
        // 图片校验
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), type)) {
                isLegal = true;
                break;  // 只要与允许上传格式其中一个匹配就可以
            }
        }
        // 格式错误, 返回false
        return isLegal;
    }
}
