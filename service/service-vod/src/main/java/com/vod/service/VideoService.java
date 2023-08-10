package com.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @description: 视频服务接口
 * @author: mark
 * @create: 2023-08-10 16:39
 **/
public interface VideoService {

    String uploadVideo(MultipartFile file);

    void deleteVideo(String videoId);
}
