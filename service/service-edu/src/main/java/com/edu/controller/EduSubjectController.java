package com.edu.controller;


import com.commonutils.R;
import com.edu.entity.vo.subject.SubjectNestedVo;
import com.edu.service.EduSubjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    /**
     * 根据接收excel文件，读取并持久化到数据库
     * @param file 文件对象
     * @return 返回R对象
     */
    @SneakyThrows
    @Operation(summary = "上传excel文件",description = "根据接收excel文件，读取并持久化到数据库",
            parameters = {@Parameter(name = "file", description = "文件对象")})
    @ApiResponse(description = "返回R对象", responseCode = "0/1 成功返回1，失败返回0")
    @PostMapping
    public R addSubject(MultipartFile file){
    //1 获取上传的excel文件 MultipartFile
    //返回错误提示信息
        eduSubjectService.importSubjectData(file);
    //判断返回集合是否为空
        return R.ok();
    }

    /**
     * 从数据库中读取课程分类信息，并将二级分类封装到一级分类中
     * @return 返回一个包含全部一级分类的对象
     */
    @Operation(summary = "获取课程分类信息",description = "从数据库中读取课程分类信息，并将二级分类封装到一级分类中")
    @ApiResponse(description = "返回R对象", responseCode = "包含状态码，成功信息及其查询到的详细信息")
    @GetMapping
    public R nestedList(){
        List<SubjectNestedVo> subjectNestedVoList = eduSubjectService.nestedList();
        return R.ok().data("list", subjectNestedVoList);
    }
}

