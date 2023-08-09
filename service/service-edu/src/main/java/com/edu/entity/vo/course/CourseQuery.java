package com.edu.entity.vo.course;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 课程查询对象封装
 * @author: mark
 * @create: 2023-08-09 21:11
 **/
@Data
public class CourseQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(title = "标题")
    private String title;
    @Schema(title = "讲师id")
    private String teacherId;
    @Schema(title = "课程一级分类(例如:前端开发、后端开发、数据库开发)")
    private String subjectParentId;
    @Schema(title = "课程二级分类(例如：java、vue)")
        private String subjectId;
}
