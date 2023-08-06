package com.edu.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 课程简介(EduCourseDescription)表实体类
 *
 * @author mark
 * @since 2023-08-06 12:57:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduCourseDescription {
    //课程ID
    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    //课程简介
    private String description;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}

