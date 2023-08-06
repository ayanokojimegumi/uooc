package com.edu.controller;


import com.commonutils.R;
import com.edu.entity.vo.CourseInfoFormVo;
import com.edu.service.EduCourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
     * 修改数据
     *
     * @param eduCourse 实体对象
     * @return 修改结果
     */

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */

}

