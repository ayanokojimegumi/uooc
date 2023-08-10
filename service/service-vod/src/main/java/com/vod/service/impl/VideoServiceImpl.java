package com.vod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.servicebase.exception.UoocException;
import com.vod.service.VideoService;
import com.vod.utils.AliyunVodSDKUtils;
import com.vod.utils.ConstantPropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description: 视频服务接口实现类
 * @author: mark
 * @create: 2023-08-10 16:39
 **/
@Slf4j
@Service
public class VideoServiceImpl implements VideoService {

    /**
     * 将上传的视频文件存储到阿里云中
     * @param file 视频文件对象
     * @return 返回视频在阿里云点播服务存储的id
     */
    @Override
    public String uploadVideo(MultipartFile file) {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            String filename = file.getOriginalFilename();
            String title = filename.substring(0, filename.lastIndexOf("."));
            UploadStreamRequest request = new UploadStreamRequest(
                    ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET,
                    title, filename, inputStream);
            request.setCateId(1000503838L);
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);
            String videoId = response.getVideoId();
            if (!response.isSuccess()) {
                String errorMessage = "阿里云上传错误：" + "code：" + response.getCode() +
                        ", message：" + response.getMessage();
                log.warn(errorMessage);
                if(StringUtils.isEmpty(videoId)){
                    throw new UoocException(20001, errorMessage);
                }
            }
            return videoId;
        } catch (IOException e) {
            throw new UoocException(20001, "Uooc vod服务上传失败");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 根据阿里云存储的视频id，将上传的视频文件删除
     * @param videoId 上传的视频对象id
     * @return 返回删除成功状态码及删除信息
     */
    @Override
    public void deleteVideo(String videoId) {
        try {
            DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(
                    ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET);
            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(videoId);
            DeleteVideoResponse response = client.getAcsResponse(request);
            System.out.print("RequestId = " + response.getRequestId() + "\n");
        } catch (ClientException e) {
            throw new UoocException(20001, "视频删除失败");
        }
    }
}
