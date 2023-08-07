package com.edu.controller;


import com.commonutils.R;
import com.edu.entity.vo.chapter.ChapterVo;
import com.edu.service.EduChapterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程(EduChapter)表控制层
 *
 * @author mark
 * @since 2023-08-06 12:48:19
 */
@RestController
@RequestMapping("/eduservice/chapter")
@CrossOrigin
@Tag(name = "EduChapterController", description = "课程章节api")
public class EduChapterController {
    /**
     * 服务对象
     */
    @Resource
    private EduChapterService eduChapterService;

    @GetMapping("/{courseId}")
    public R getChapterByCourseId(@PathVariable("courseId") String courseId) {
        List<ChapterVo> chapterVoList = eduChapterService.getChapterByCourseId(courseId);
        return R.ok().data("chapterVoList", chapterVoList);
    }

}

