package com.edu.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 课程(EduChapter)表实体类
 *
 * @author mark
 * @since 2023-08-06 12:48:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduChapter {
    //章节ID
    private String id;
    //课程ID
    private String courseId;
    //章节名称
    private String title;
    //显示排序
    private Integer sort;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}

