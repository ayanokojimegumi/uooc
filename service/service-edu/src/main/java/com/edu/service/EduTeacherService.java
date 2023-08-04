package com.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.commonutils.R;
import com.edu.entity.EduTeacher;
import com.edu.entity.vo.TeacherQuery;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 讲师(EduTeacher)表服务接口
 *
 * @author mark
 * @since 2023-08-02 00:31:45
 */
public interface EduTeacherService extends IService<EduTeacher> {
    R pageQuery(Long page, Long limit, TeacherQuery teacherQuery);
     R pageList(Long page, Long limit);
}

