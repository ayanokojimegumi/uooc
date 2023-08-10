package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.entity.EduVideo;
import com.edu.entity.vo.video.VideoInfoFormVo;

/**
 * 课程视频(EduVideo)表服务接口
 *
 * @author mark
 * @since 2023-08-06 13:01:01
 */
public interface EduVideoService extends IService<EduVideo> {

    boolean getCourseByChapterId(String chapterId);

    void saveVideoInfo(VideoInfoFormVo videoInfoFormVo);

    void updateVideoById(VideoInfoFormVo videoInfoFormVo);

    VideoInfoFormVo getVideoById(String id);

    boolean deleteVideoById(String id);

    boolean deleteVideoByCourseId(String id);
}

