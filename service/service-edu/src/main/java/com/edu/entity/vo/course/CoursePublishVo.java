package com.edu.entity.vo.course;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 课程发布信息
 * @author: mark
 * @create: 2023-08-08 17:48
 **/
@Data
public class CoursePublishVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示
}
