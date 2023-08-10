package com.edu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.commonutils.R;
import com.edu.entity.EduCourse;
import com.edu.entity.vo.course.CourseInfoFormVo;
import com.edu.entity.vo.course.CoursePublishVo;
import com.edu.entity.vo.course.CourseQuery;
import com.edu.service.EduCourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程(EduCourse)表控制层
 *
 * @author mark
 * @since 2023-08-06 12:54:04
 */
@Tag(name = "EduCourseController", description = "课程管理api")
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {
    /**
     * 服务对象
     */
    @Resource
    private EduCourseService eduCourseService;

    /**
     * 添加课程基本信息
     *
     * @param courseInfoFormVo 实体对象
     * @return 新增结果
     */
    @Operation(summary = "添加课程基本信息",
            parameters = {@Parameter(name = "courseInfoFormVo", description = "课程基本信息")})
    @ApiResponse(description = "返回一个R对象，包含状态码及详细信息")
    @PostMapping
    public R addCourseInfo(@RequestBody CourseInfoFormVo courseInfoFormVo) {
        String id = eduCourseService.saveCourseInfo(courseInfoFormVo);
        return R.ok().data("courseId", id);
    }

    /**
     * 根据课程id查询课程的详细信息
     * @param id 课程id
     * @return 返回课程的详细信息
     */
    @Operation(summary = "根据课程id查询课程的详细信息",
            parameters = {@Parameter(name = "id", description = "课程id")})
    @ApiResponse(description = "返回一个R对象，包含状态码及详细信息")
   @GetMapping("/{id}")
    public R getCourseById(@PathVariable String id) {
        CourseInfoFormVo courseInfoFormVo = eduCourseService.getCourseById(id);
        return R.ok().data("courseInfoForm", courseInfoFormVo);
   }

    /**
     * 修改课程详细信息
     * @param courseInfoFormVo 课程对象
     * @return 返回一个R对象，包含状态码及是否成功的信息
     */
    @Operation(summary = "修改课程详细信息",
            parameters = {@Parameter(name = "CourseInfoFormVo", description = "课程对象")})
    @ApiResponse(description = "返回一个R对象，包含状态码及是否成功的信息")
    @PutMapping
    public R updateCourseById(@RequestBody CourseInfoFormVo courseInfoFormVo) {
        eduCourseService.updateCourseById(courseInfoFormVo);
        return R.ok();
    }

    /**
     * 根据id获取课程的详细信息
     * @param id 课程id
     * @return 返回一个R对象，包含状态码及是否成功的信息
     */
    @Operation(summary = "根据id获取课添加的发布的课程的详细信息",
            parameters = {@Parameter(name = "id", description = "发布课程id")})
    @ApiResponse(description = "返回一个R对象，包含状态码及是否成功的信息")
    @GetMapping("/publish/{id}")
    public R getCoursePublishVoById(@PathVariable("id") String id){
        CoursePublishVo coursePublishVo = eduCourseService.getCoursePublishVoById(id);
        return R.ok().data("coursePublishVo", coursePublishVo);
    }

    /**
     * 根据id获取课添加的课程详细信息
     * @param id 课程id
     * @return 返回一个R对象，包含状态码及是否成功的信息
     */
    @Operation(summary = "根据id获取课添加的课程详细信息,并且发布课程",
            parameters = {@Parameter(name = "id", description = "发布课程id")})
    @ApiResponse(description = "返回一个R对象，包含状态码及是否成功的信息")
    @PostMapping("/publishCourse/{id}")
    public R publishCourseById(@PathVariable("id") String id) {
        eduCourseService.publishCourseById(id);
        return R.ok();

    }

    /**
     * 根据封装的课程查询条件对象，进行课程分页查询，并将查询到的行数和数据返回
     * @param page 当前页
     * @param limit 每页限制最多多少条数据
     * @param courseQuery 封装的课程条件查询对象
     * @return 返回查询到的数据总数total，以及查询到的详细课程信息
     */
    @Operation(
            summary = "根据封装的课程查询条件对象，进行课程分页查询，并将查询到的行数和数据返回",
            parameters = {@Parameter(name = "page", description = "当前页"),
                    @Parameter(name = "limit", description = "每页限制最多多少条数据"),
                    @Parameter(name = "courseQuery", description = "封装的课程条件查询对象")})
    @ApiResponse(description = "返回查询到的数据总数total，以及查询到的详细课程信息")
    @PostMapping("/{page}/{limit}")
    public R pageQuery(@PathVariable("page")Long page, @PathVariable("limit") Long limit, @RequestBody CourseQuery courseQuery) {
        Page<EduCourse> pageParam = new Page<>(page, limit);
        eduCourseService.pageQuery(pageParam, courseQuery);
        List<EduCourse> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("total", total).data("records", records);
    }

    @Operation(summary = "根据id删除课程信息，包括课程的视频信息，章节信息",
            parameters = {@Parameter(name = "id", description = "发布的课程id")})
    @ApiResponse(description = "返回状态码及是否成功的信息")
    @DeleteMapping("/{id}")
    public R deleteCourseById(@PathVariable("id") String id) {
        boolean result = eduCourseService.removeCourseById(id);
        if (result) {
            return R.ok();
        } else {
            return R.error().message("删除课程失败");
        }
    }
}

