package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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

    /**
     * 根据以发布的课程id，删除该课程的课程简介
     * @param id 发布的课程id
     * @return 成功则返回true，失败返回false
     */
    @Override
    public boolean deleteByCourseId(String id) {
        LambdaQueryWrapper<EduCourseDescription> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EduCourseDescription::getId, id);
        boolean result = this.remove(queryWrapper);
        return result;
    }
}

