package com.edu.entity.vo.course;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description: 课程基本信息, 编辑课程基本信息的表单对象
 * @author: mark
 * @create: 2023-08-06 13:12
 **/
@Data
public class CourseInfoFormVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(title = "课程ID")
    private String id;
    @Schema(title = "课程讲师ID")
    private String teacherId;
    @Schema(title = "课程专业ID")
    private String subjectId;
    @Schema(title = "课程分类ID")
    private String subjectParentId;
    @Schema(title = "课程标题")
    private String title;
    @Schema(title = "课程销售价格，设置为0则可免费观看")
    private BigDecimal price;
    @Schema(title = "总课时")
    private BigDecimal lessonNum;
    @Schema(title = "课程封面图片路径")
    private String cover;
    @Schema(title = "课程简介")
    private String description;
}
