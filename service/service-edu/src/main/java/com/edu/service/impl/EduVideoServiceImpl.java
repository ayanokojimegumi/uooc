package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.entity.vo.video.VideoInfoFormVo;
import com.edu.mapper.EduVideoMapper;
import com.edu.entity.EduVideo;
import com.edu.service.EduVideoService;
import com.servicebase.exception.UoocException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 课程视频(EduVideo)表服务实现类
 *
 * @author mark
 * @since 2023-08-06 13:01:01
 */
@Service("eduVideoService")
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    /**
     * 根据章节id查询该章节下的所有视频信息
     * @param chapterId 章节id
     * @return  返回值大于0，则表示该章节下有视频
     */
    @Override
    public boolean getCourseByChapterId(String chapterId) {
        LambdaQueryWrapper<EduVideo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EduVideo::getChapterId, chapterId);
        Long count = baseMapper.selectCount(wrapper);
        if (count > 0) return true;
        else return false;
    }

    /**
     * 接收前端封装的视频对象，新增视频信息
     * @param videoInfoFormVo 前端发送的视频对象
     */
    @Override
    public void saveVideoInfo(VideoInfoFormVo videoInfoFormVo) {
        //保存课时信息
        EduVideo video = new EduVideo();
        BeanUtils.copyProperties(videoInfoFormVo, video);
        boolean flag = this.save(video);
        if (!flag) {
            throw new UoocException(20001, "课时信息保存失败");
        }
    }
    /**
     * 接收前端封装的视频对象，修改视频信息
     * @param videoInfoFormVo 前端发送的视频对象
     */
    @Override
    public void updateVideoById(VideoInfoFormVo videoInfoFormVo) {
        //保存课时信息
        EduVideo video = new EduVideo();
        BeanUtils.copyProperties(videoInfoFormVo, video);
        boolean flag = this.updateById(video);
        if (!flag) {
            throw new UoocException(20001, "课时信息修改失败");
        }
    }

    /**
     * 根据课时id查询相应的课时信息，并封装到videoInfoFormVo对象，返回给前端
     * @param id 课时id
     */
    @Override
    public VideoInfoFormVo getVideoById(String id) {
        //查询课程信息
        EduVideo video = this.getById(id);
        if (video == null) {
            throw new UoocException(20001, "数据不存在");
        }
        //封装到VideoInfoFormVo并返回
        VideoInfoFormVo infoFormVo = new VideoInfoFormVo();
        BeanUtils.copyProperties(video, infoFormVo);
        return infoFormVo;
    }

    /**
     * 根据课时id删除相应的课时信息
     * @param id 课时id
     */
    @Override
    public boolean deleteVideoByid(String id) {
        int result = baseMapper.deleteById(id);
        return result > 0;
    }


}

