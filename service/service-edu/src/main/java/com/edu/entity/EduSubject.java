package com.edu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 课程科目(EduSubject)表实体类
 *
 * @author mark
 * @since 2023-08-05 22:42:38
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduSubject{
//课程类别ID
    private String id;
//类别名称
    private String title;
//父ID
    private String parentId;
//排序字段
    private Integer sort;
//创建时间
    private Date gmtCreate;
//更新时间
    private Date gmtModified;
}

