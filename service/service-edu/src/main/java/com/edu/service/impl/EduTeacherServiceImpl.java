package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.commonutils.R;
import com.edu.entity.EduTeacher;
import com.edu.entity.vo.TeacherQuery;
import com.edu.mapper.EduTeacherMapper;
import com.edu.service.EduTeacherService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 讲师(EduTeacher)表服务实现类
 *
 * @author mark
 * @since 2023-08-02 00:31:45
 */
@Service("eduTeacherService")
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    /**
     * 服务对象
     */
    @Resource
    private EduTeacherMapper teacherMapper;



    /**
     * 模糊分页查询,根据条件进行查询，没有条件时，默认全部查询并且分页
     * @param page 当前页
     * @param limit 每页多少条数据
     * @param teacherQuery  查询条件对象
     * @return 根据条件查询的结果，返回相应的教师信息，如没条件，返回所有教师信息
     */
    @Override
    public R pageQuery(Long page, Long limit, TeacherQuery teacherQuery) {
        //页面对象
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        //条件
        LambdaQueryWrapper<EduTeacher> queryWrapper = new LambdaQueryWrapper<>();
        //如果没有条件，查询所有教师信息
        if (teacherQuery == null) {
            teacherMapper.selectPage(pageParam, queryWrapper);
            List<EduTeacher> records = pageParam.getRecords();
            long total = pageParam.getTotal();
            return R.ok()
                    .data("total", total)
                    .data("records", records);
        }

        //获取条件
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        //如果名字不为空，按照名字查
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like(EduTeacher::getName, name);
        }

        if (!StringUtils.isEmpty(level)) {
            queryWrapper.eq(EduTeacher::getLevel, level);
        }
        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge(EduTeacher::getGmtCreate, begin);
        }
        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le(EduTeacher::getGmtCreate, end);
        }
        queryWrapper.orderByDesc(EduTeacher::getGmtModified);
        //都不为空，按照所有条件查
        teacherMapper.selectPage(pageParam, queryWrapper);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok()
                .data("total", total)
                .data("records", records);
    }
}

