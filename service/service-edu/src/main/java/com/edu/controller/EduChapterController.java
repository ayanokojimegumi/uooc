package com.edu.controller;


import com.commonutils.R;
import com.edu.entity.EduChapter;
import com.edu.entity.vo.chapter.ChapterVo;
import com.edu.service.EduChapterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    /**
     * 根据课程id获取课程的详细信息，和简介详细信息，并封装成ChapterVo
     * @param courseId 课程id
     * @return 将查询到的章节和视频的信息封装到ChapterVo对象
     */
    @Operation(summary = "根据课程id查询课程的详细信息",
            parameters = {@Parameter(name = "courseId", description = "课程id")})
    @ApiResponse(description = "返回一个R对象，包含状态码及详细信息")
    @GetMapping("getcourse/{courseId}")
    public R getChapterByCourseId(@PathVariable("courseId") String courseId) {
        List<ChapterVo> chapterVoList = eduChapterService.getChapterByCourseId(courseId);
        return R.ok().data("chapterVoList", chapterVoList);
    }

    /**
     * 新增章节信息
     * @param chapter 章节对象
     * @return 返回一个R对象，包含状态码及详细信息
     */
    @Operation(summary = "新增章节信息",
            parameters = {@Parameter(name = "chapter", description = "章节对象")})
    @ApiResponse(description = "返回一个R对象，包含状态码及详细信息")
    @PostMapping
    public R addChapter(@RequestBody EduChapter chapter) {
        eduChapterService.save(chapter);
        return R.ok();
    }

    /**
     * 根据id查询章节信息
     * @param id 章节id
     * @return 返回章节信息
     */
    @Operation(summary = "根据id查询章节信息",
            parameters = {@Parameter(name = "id", description = "章节id")})
    @ApiResponse(description = "返回一个R对象，包含状态码及章节信息")
    @GetMapping("/{id}")
    public R getCourseById(@PathVariable("id") String id) {
        EduChapter chapter = eduChapterService.getById(id);
        return R.ok().data("chapter", chapter);
    }

    /**
     * 根据id更改章节信息
     * @param chapter 章节对象
     * @return 返回一个R对象，包含状态码
     */
    @Operation(summary = "根据id更改章节信息",
            parameters = {@Parameter(name = "id", description = "章节对象")})
    @ApiResponse(description = "返回一个R对象，包含状态码及章节信息")
    @PutMapping
    public R updateChapterById(@RequestBody EduChapter chapter) {
        eduChapterService.updateById(chapter);
        return R.ok();
    }

    /**
     * 根据id删除章节信息
     * @param id 章节id
     * @return 返回一个R对象，包含状态码及章节信息
     */
    @Operation(summary = "根据id删除章节信息",
            parameters = {@Parameter(name = "id", description = "章节id")})
    @ApiResponse(description = "返回一个R对象，包含状态码及章节信息")
    @DeleteMapping("/{id}")
    public R deleteCourseById(@PathVariable("id") String id) {
        boolean flag = eduChapterService.removeChapterById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error().message("删除失败");
        }
    }
}

