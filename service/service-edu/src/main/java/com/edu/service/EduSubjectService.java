package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.entity.EduSubject;
import com.edu.entity.vo.SubjectNestedVo;
import com.servicebase.exception.NotDataFormExcelException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 课程科目(EduSubject)表服务接口
 *
 * @author mark
 * @since 2023-08-05 22:42:38
 */
public interface EduSubjectService extends IService<EduSubject> {

    void importSubjectData(MultipartFile file) throws NotDataFormExcelException;

    List<SubjectNestedVo> nestedList();
}

