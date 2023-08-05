package com.edu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.edu.entity.EduSubject;
import com.edu.entity.excel.ExcelSubjectData;
import com.edu.service.EduSubjectService;
import com.servicebase.exception.NotDataFormExcelException;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: easyexcel读取文件监听类
 * @author: mark
 * @create: 2023-08-05 22:17
 **/
public class SubjectExcelListener implements ReadListener<ExcelSubjectData> {
    @Resource
    public EduSubjectService subjectService;
    //创建有参数构造，传递subjectService用于操作数据库

    public SubjectExcelListener() {}

    public SubjectExcelListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    @Transactional
    public void invoke(ExcelSubjectData excelSubjectData, AnalysisContext analysisContext) {
        if(excelSubjectData == null) {
            try {
                throw new NotDataFormExcelException("excel中数据为空");
            } catch (NotDataFormExcelException e) {
                throw new RuntimeException(e);
            }
        }
        EduSubject existOneSubject = this.existOneSubject(excelSubjectData.getOneSubjectName());
        if(existOneSubject == null) {
            //没有相同的
            existOneSubject = new EduSubject();
            existOneSubject.setTitle(excelSubjectData.getOneSubjectName());
            existOneSubject.setParentId("0");
            subjectService.save(existOneSubject);
        }
        //获取一级分类id值
        String pid = existOneSubject.getId();
//添加二级分类
        EduSubject existTwoSubject = this.existTwoSubject(excelSubjectData.getTwoSubjectName(), pid);
        if(existTwoSubject == null) {
            existTwoSubject = new EduSubject();
            existTwoSubject.setTitle(excelSubjectData.getTwoSubjectName());
            existTwoSubject.setParentId(pid);
            subjectService.save(existTwoSubject);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
    //判断一级分类是否重复
    private EduSubject existTwoSubject(String name, String pid) {
        LambdaQueryWrapper<EduSubject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EduSubject::getTitle, name);
        wrapper.eq(EduSubject::getParentId, pid);
        EduSubject eduSubject = subjectService.getOne(wrapper);
        return eduSubject;
    }

    private EduSubject existOneSubject(String name) {
        LambdaQueryWrapper<EduSubject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EduSubject::getTitle, name);
        wrapper.eq(EduSubject::getParentId, "0");
        EduSubject eduSubject = subjectService.getOne(wrapper);
        return eduSubject;
    }
}