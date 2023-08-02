package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.service.EduTeacherService;
import com.edu.mapper.EduTeacherMapper;
import com.edu.entity.EduTeacher;
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

