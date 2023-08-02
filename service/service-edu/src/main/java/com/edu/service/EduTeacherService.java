package com.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.commonutils.R;
import com.edu.entity.EduTeacher;
import com.edu.entity.vo.TeacherQuery;

/**
 * 讲师(EduTeacher)表服务接口
 *
 * @author mark
 * @since 2023-08-02 00:31:45
 */
public interface EduTeacherService extends IService<EduTeacher> {
    R pageQuery(int page, int limit, TeacherQuery teacherQuery);

}

