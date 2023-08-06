package com.edu.controller;


import com.edu.service.EduCourseDescriptionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程简介(EduCourseDescription)表控制层
 *
 * @author mark
 * @since 2023-08-06 12:57:37
 */
@RestController
@RequestMapping("eduCourseDescription")
@CrossOrigin
public class EduCourseDescriptionController {
    /**
     * 服务对象
     */
    @Resource
    private EduCourseDescriptionService eduCourseDescriptionService;

    /**
     * 分页查询所有数据
     *
     * @param page                 分页对象
     * @param eduCourseDescription 查询实体
     * @return 所有数据
     */


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */

    /**
     * 新增数据
     *
     * @param eduCourseDescription 实体对象
     * @return 新增结果
     */


    /**
     * 修改数据
     *
     * @param eduCourseDescription 实体对象
     * @return 修改结果
     */


    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */

}

