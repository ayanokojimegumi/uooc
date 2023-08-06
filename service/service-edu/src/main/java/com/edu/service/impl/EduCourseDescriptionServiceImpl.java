package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.mapper.EduCourseDescriptionMapper;
import com.edu.entity.EduCourseDescription;
import com.edu.service.EduCourseDescriptionService;
import org.springframework.stereotype.Service;

/**
 * 课程简介(EduCourseDescription)表服务实现类
 *
 * @author mark
 * @since 2023-08-06 12:57:37
 */
@Service("eduCourseDescriptionService")
public class EduCourseDescriptionServiceImpl extends ServiceImpl<EduCourseDescriptionMapper, EduCourseDescription> implements EduCourseDescriptionService {

}

