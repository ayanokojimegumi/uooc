package com.oss.controller;

import com.commonutils.R;
import com.oss.service.UploadService;
import com.servicebase.exception.UoocException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description: 文件操作控制器类
 * @author: mark
 * @create: 2023-08-04 17:26
 **/
@Tag(name = "OssController", description = "文件操作控制器类")
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Resource
    UploadService fileService;

    /**
     * 上传讲师头像
     * @param file 需要上传的图片文件
     * @return 返回一个R对象的JSON数据，包含成功状态码、成功信息等
     */
    @Operation(summary = "讲师头像上传", description = "将上传的文件存储到阿里云OSS中",
            parameters = {@Parameter(name = "file", description = "文件对象")})
    @ApiResponse(description = "返回文件在阿里云OSS中的URL路径")
    @PostMapping(consumes = "multipart/form-data")
    public R uploadOssFile(@RequestParam("file") MultipartFile file) {
        //获取上传文件路径
        String url;
        try {
            url = fileService.upload(file);
        } catch (UoocException e) {
           return R.error().message(e.getMessage());
        }
        return R.ok().message("文件上传成功").data("url", url);
    }

}
