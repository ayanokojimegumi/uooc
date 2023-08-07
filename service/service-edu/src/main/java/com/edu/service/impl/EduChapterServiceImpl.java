package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.entity.EduChapter;
import com.edu.entity.EduVideo;
import com.edu.entity.vo.chapter.ChapterVo;
import com.edu.entity.vo.chapter.VideoVo;
import com.edu.mapper.EduChapterMapper;
import com.edu.service.EduChapterService;
import com.edu.service.EduVideoService;
import com.servicebase.exception.UoocException;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程(EduChapter)表服务实现类
 *
 * @author mark
 * @since 2023-08-06 12:48:28
 */
@Service("eduChapterService")
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {
    /**
     * 课程时长
     */
    @Resource
    private EduVideoService videoService;

    /**
     * 根据课程id获取课程相应的章节信息和课时信息，并封装到ChapterVo中，
     * ChapterVo类包括三个字段(id（章节id），title（章节标题），children<VideoVo>（章节的所有视频）)
     * @param courseId 课程id
     * @return List<ChapterVo> 返回一个课程中所有的章节及其章节对应的视频
     */
    @Override
    public List<ChapterVo> getChapterByCourseId(String courseId) {
        //最终要的到的数据列表
        ArrayList<ChapterVo> chapterVoArrayList = new ArrayList<>();
        //获取一级分类数据记录
        LambdaQueryWrapper<EduChapter> chapterWrapper = new LambdaQueryWrapper<>();
        chapterWrapper.eq(EduChapter::getCourseId, courseId);
        chapterWrapper.orderByAsc(EduChapter::getSort, EduChapter::getCourseId);
        List<EduChapter> chapterList = this.list(chapterWrapper);
        //保存ChapterVo

        //遍历chapterList
        for (EduChapter chapters : chapterList) {
            //获取课程时长信息
            LambdaQueryWrapper<EduVideo> videoWrapper = new LambdaQueryWrapper<>();
            videoWrapper.eq(EduVideo::getCourseId, courseId);
            videoWrapper.orderByAsc(EduVideo::getSort, EduVideo::getId);
            List<EduVideo> videoList = videoService.list(videoWrapper);
            //保存课程视频信息
            List<VideoVo> videoVos = new ArrayList<>();
            //遍历videoList，将其中的video中对应的信息添加到videoVos集合中。
            for (EduVideo videos: videoList) {
                VideoVo videoVo = new VideoVo();
                //将videos类中和videoVo类中的共同字段，赋值给videoVo类
                BeanUtils.copyProperties(videos, videoVo);
                //添加到videoVos集合中
                videoVos.add(videoVo);
            }
            //添加章节
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapters, chapterVo);
            //将该章节下对应的视频添加到chapterVo类的child集合
            chapterVo.setChildren(videoVos);
            //将chapterVo添加到chapterVos集合
            chapterVoArrayList.add(chapterVo);
        }
        return chapterVoArrayList;
    }

    @Override
    public boolean removeChapterById(String id) {
        if (videoService.getCourseByChapterId(id)) {
            throw new UoocException(20001,"该分章节下存在视频课程，请先删除视频课程");
        }
        Integer count = baseMapper.deleteById(id);
        return count != null && count > 0;
    }
}

