package com.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.entity.EduCourseDescription;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程简介(EduCourseDescription)表数据库访问层
 *
 * @author mark
 * @since 2023-08-06 12:57:37
 */
@Mapper
public interface EduCourseDescriptionMapper extends BaseMapper<EduCourseDescription> {

}

