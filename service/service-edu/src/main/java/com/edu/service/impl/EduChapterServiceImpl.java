package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
        ArrayList<ChapterVo> chapterVoArrayList = new ArrayList<>();
        //获取章节信息
        QueryWrapper<EduChapter> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("course_id", courseId);
        queryWrapper1.orderByAsc("sort", "id");
        List<EduChapter> chapters = baseMapper.selectList(queryWrapper1);
        //获取课时信息
        QueryWrapper<EduVideo> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("course_id", courseId);
        queryWrapper2.orderByAsc("sort", "id");
        List<EduVideo> videos = videoService.list(queryWrapper2);
        //填充章节vo数据
        int count1 = chapters.size();
        for (int i = 0; i < count1; i++) {
            EduChapter chapter = chapters.get(i);
            //创建章节vo对象
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);
            chapterVoArrayList.add(chapterVo);
            //填充课时vo数据
            ArrayList<VideoVo> videoVoArrayList = new ArrayList<>();
            int count2 = videos.size();
            for (int j = 0; j < count2; j++) {
                EduVideo video = videos.get(j);
                if(chapter.getId().equals(video.getChapterId())){
                    //创建课时vo对象
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video, videoVo);
                    videoVoArrayList.add(videoVo);
                }
            }
            chapterVo.setChildren(videoVoArrayList);
        }
        return chapterVoArrayList;
    }

    @Override
    public boolean removeChapterById(String id) {
        if (videoService.getCourseByChapterId(id)) {
            throw new UoocException(20001,"该分章节下存在视频课程，请先删除视频课程");
        }
        int count = baseMapper.deleteById(id);
        return count > 0;
    }
}

