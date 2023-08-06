package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.mapper.EduCourseMapper;
import com.edu.entity.EduCourse;
import com.edu.service.EduCourseService;
import org.springframework.stereotype.Service;

/**
 * 课程(EduCourse)表服务实现类
 *
 * @author mark
 * @since 2023-08-06 12:54:08
 */
@Service("eduCourseService")
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

}

