package com.edu.controller;


import com.commonutils.R;
import com.edu.entity.vo.SubjectNestedVo;
import com.edu.service.EduSubjectService;
import com.servicebase.exception.NotDataFormExcelException;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 课程科目(EduSubject)表控制层
 *
 * @author mark
 * @since 2023-08-05 22:42:38
 */
@RestController
@RequestMapping("eduservice/subject")
@CrossOrigin
public class EduSubjectController {
    /**
     * 服务对象
     */
    @Resource
    private EduSubjectService eduSubjectService;

    @SneakyThrows
    @PostMapping
    public R addSubject(MultipartFile file){
    //1 获取上传的excel文件 MultipartFile
    //返回错误提示信息
        eduSubjectService.importSubjectData(file);
    //判断返回集合是否为空
        return R.ok();
    }

    @GetMapping
    public R nestedList(){
        List<SubjectNestedVo> subjectNestedVoList = eduSubjectService.nestedList();
        return R.ok().data("list", subjectNestedVoList);
    }
}

