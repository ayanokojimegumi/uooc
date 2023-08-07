package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.entity.EduChapter;
import com.edu.entity.vo.chapter.ChapterVo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 课程(EduChapter)表服务接口
 *
 * @author mark
 * @since 2023-08-06 12:48:27
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterByCourseId(String courseId);

    boolean removeChapterById(String id);
}

