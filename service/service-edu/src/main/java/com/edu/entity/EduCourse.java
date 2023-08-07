package com.edu.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 课程(EduCourse)表实体类
 *
 * @author mark
 * @since 2023-08-06 12:54:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduCourse{
    //课程ID
    private String id;
    //课程讲师ID
    private String teacherId;
    //课程专业Id(二级分类id)
    private String subjectId;
    //一级分类id
    private String subjectParentId;
    //课程标题
    private String title;
    //课程销售价格，设置为0则可免费观看
    private BigDecimal price;
    //总课时
    private BigDecimal lessonNum;
    //课程封面图片路径
    private String cover;
    //销售数量
    private Long buyCount;
    //浏览数量
    private Long viewCount;
    //乐观锁
    private Long version;
    //课程状态 Draft未发布  Normal已发布
    private String status;
    //逻辑删除 1（true）已删除， 0（false）未删除
    private Integer isDeleted;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}

