package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.entity.EduCourse;
import com.edu.entity.vo.course.CourseInfoFormVo;

/**
 * 课程(EduCourse)表服务接口
 *
 * @author mark
 * @since 2023-08-06 12:54:08
 */
public interface EduCourseService extends IService<EduCourse> {


    String saveCourseInfo(CourseInfoFormVo courseInfoFormVo);

    CourseInfoFormVo getCourseById(String courseId);

    void updateCourseById(CourseInfoFormVo courseInfoFormVo);
}

