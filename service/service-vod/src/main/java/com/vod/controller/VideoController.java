package com.vod.controller;

import com.commonutils.R;
import com.vod.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description: 阿里云视频点播微服务控制器
 * @author: mark
 * @create: 2023-08-10 16:37
 **/
@Tag(name = "VideoController", description = "阿里云视频点播微服务控制器")
@RestController
@RequestMapping("/eduvod/video")
@CrossOrigin
public class VideoController {
    /**
     * 注入VideoService对象
     */
    @Resource
    private VideoService videoService;

    /**
     * 将上传的视频文件存储到阿里云中
     * @param file 视频文件对象
     * @return 返回视频在阿里云点播服务存储的id
     */
    @Operation(summary = "视频上传", description = "将上传的视频文件存储到阿里云中",
            parameters = {@Parameter(name = "file", description = "视频文件对象")})
    @ApiResponse(description = "返回视频在阿里云点播服务存储的id")
    @PostMapping(consumes = "multipart/form-data")
    public R uploadVideo(@RequestParam("file") MultipartFile file) {
        String videoId = videoService.uploadVideo(file);
        return R.ok().message("视频上传成功").data("videoId", videoId);
    }

    /**
     * 根据阿里云存储的视频id，将上传的视频文件删除
     * @param id 上传的视频对象id
     * @return 返回删除成功状态码及删除信息
     */
    @Operation(summary = "视频删除", description = "根据阿里云存储的视频id，将上传的视频文件删除",
            parameters = {@Parameter(name = "id", description = "上传的视频对象id")})
    @ApiResponse(description = "返回删除成功状态码及删除信息")
    @DeleteMapping("/{id}")
    public R deleteVideo(@PathVariable("id") String id) {
        videoService.deleteVideo(id);
        return R.ok().message("视频删除成功");
    }
}
