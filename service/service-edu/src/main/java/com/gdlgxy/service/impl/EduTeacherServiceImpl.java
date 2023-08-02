package com.gdlgxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdlgxy.service.EduTeacherService;
import com.gdlgxy.mapper.EduTeacherMapper;
import com.gdlgxy.entity.EduTeacher;
import org.springframework.stereotype.Service;

/**
 * 讲师(EduTeacher)表服务实现类
 *
 * @author mark
 * @since 2023-08-02 00:31:45
 */
@Service("eduTeacherService")
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

}

