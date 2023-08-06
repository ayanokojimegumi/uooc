package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.entity.EduCourseDescription;
import com.edu.entity.vo.CourseInfoFormVo;
import com.edu.mapper.EduCourseMapper;
import com.edu.entity.EduCourse;
import com.edu.service.EduCourseDescriptionService;
import com.edu.service.EduCourseService;
import com.servicebase.exception.UoocException;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 课程(EduCourse)表服务实现类
 *
 * @author mark
 * @since 2023-08-06 12:54:08
 */
@Service("eduCourseService")
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Resource
    private EduCourseDescriptionService descriptionService;
    /**
     * 添加课程基本信息
     *
     * @param courseInfoFormVo 实体对象
     * @return 新增结果
     */
    @Override
    @Transactional
    public void saveCourseInfo(CourseInfoFormVo courseInfoFormVo) {
        //1.向课程表添加课程信息
        //courseInfoFormVo转换成EduCourse对象
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoFormVo, eduCourse);
        int insert = baseMapper.insert(eduCourse);

        if (insert <= 0) {
            throw new UoocException(20001, "添加课程信息失败");
        }
        //获取eduCourse的id
        String eduCourseId = eduCourse.getId();

        //2.向课程简介表添加课程简介
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoFormVo.getDescription());
        courseDescription.setId(eduCourseId);
        descriptionService.save(courseDescription);
    }
}

