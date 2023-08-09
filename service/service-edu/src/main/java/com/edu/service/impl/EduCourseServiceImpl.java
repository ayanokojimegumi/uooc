package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.entity.EduCourseDescription;
import com.edu.entity.vo.course.CourseInfoFormVo;
import com.edu.entity.vo.course.CoursePublishVo;
import com.edu.entity.vo.course.CourseQuery;
import com.edu.mapper.EduCourseMapper;
import com.edu.entity.EduCourse;
import com.edu.service.EduCourseDescriptionService;
import com.edu.service.EduCourseService;
import com.servicebase.exception.UoocException;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
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
    public String saveCourseInfo(CourseInfoFormVo courseInfoFormVo) {
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
        return eduCourseId;
    }

    /**
     * 根据课程id获取课程的详细信息，和简介详细信息，并封装成CourseInfoFormVo
     * @param courseId 课程id
     * @return CourseInfoFormVo对象，封装了课程的基本信息和课程简介的基本信息
     */
    @Override
    public CourseInfoFormVo getCourseById(String courseId) {
        //根据id获取课程对象
        EduCourse course = this.getById(courseId);
        if (course == null) {
            throw new UoocException(20001, "课程不存在");
        }
        //创建CourseInfoFormVo对象，并将course对象和CourseInfoFormVo对象共同的
        //属性赋值给CourseInfoFormVo对象中的属性
        CourseInfoFormVo courseInfoFormVo = new CourseInfoFormVo();
        BeanUtils.copyProperties(course, courseInfoFormVo);
        //根据id查询课程的简介信息并封装到CourseInfoFormVo的description属性上
        EduCourseDescription courseDescription = descriptionService.getById(courseId);
        if (courseDescription != null) {
            courseInfoFormVo.setDescription(courseDescription.getDescription());
        }
        return courseInfoFormVo;
    }

    /**
     * 修改课程详细信息
     * @param courseInfoFormVo 课程对象
     * @return 返回一个R对象，包含状态码及是否成功的信息
     */
    @Override
    public void updateCourseById(CourseInfoFormVo courseInfoFormVo) {
        //保存课程信息
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoFormVo, eduCourse);
        //根据课程id，查询是否有该课程
        boolean flag = this.updateById(eduCourse);
        if (!flag) {
            throw new UoocException(20001, "课程信息保存失败");
        }
        //保存课程简介信息
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoFormVo.getDescription());
        courseDescription.setId(eduCourse.getId());
        boolean resultDescription = descriptionService.updateById(courseDescription);
        if (!resultDescription) {
            throw new UoocException(20001, "课程详情信息保存失败");
        }

    }

    /**
     * 根据id获取课程信息，并且封装到CoursePublishVo对象
     * @param id 课程id
     * @return CoursePublishVo
     */
    @Override
    public CoursePublishVo getCoursePublishVoById(String id) {
        return baseMapper.getCoursePublishVoById(id);

    }

    /**
     * 根据id发布课程信息
     * @param id 课程id
     */
    @Override
    public void publishCourseById(String id) {
        EduCourse course = new EduCourse();
        course.setId(id);
        course.setStatus("NORMAL");
        baseMapper.updateById(course);
    }

    /**
     * 对添加的课程信息，按条件进行分页查询
     * @param pageParam Page 分页对象
     * @param courseQuery 查询条件封装对象
     */
    @Override
    public void pageQuery(Page<EduCourse> pageParam, CourseQuery courseQuery) {
        LambdaQueryWrapper<EduCourse> queryWrapper = new LambdaQueryWrapper<>();
        //如果条件对象为空，则分页查询全部
        if (courseQuery == null) {
            baseMapper.selectPage(pageParam, queryWrapper);
        }
        //获取对应属性名
        String title = courseQuery.getTitle();
        String subjectId = courseQuery.getSubjectId();
        String teacherId = courseQuery.getTeacherId();
        String subjectParentId = courseQuery.getSubjectParentId();
        //判断对应属性名是否为空，如不为空，则按该属性名搜索
        if (!StringUtils.isEmpty(title)) {
            queryWrapper.like(EduCourse::getTitle, title);
        }
        if (!StringUtils.isEmpty(subjectId)) {
            queryWrapper.eq(EduCourse::getSubjectId, title);
        }
        if (!StringUtils.isEmpty(teacherId)) {
            queryWrapper.eq(EduCourse::getTeacherId, title);
        }
        if (!StringUtils.isEmpty(subjectParentId)) {
            queryWrapper.eq(EduCourse::getSubjectParentId, title);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }
}

