package com.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.entity.EduCourse;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程(EduCourse)表数据库访问层
 *
 * @author mark
 * @since 2023-08-06 12:54:04
 */
@Mapper
public interface EduCourseMapper extends BaseMapper<EduCourse> {

}

