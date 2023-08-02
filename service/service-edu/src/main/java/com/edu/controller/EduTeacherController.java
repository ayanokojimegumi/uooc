package com.edu.controller;


import com.edu.entity.EduTeacher;
import com.edu.service.EduTeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 讲师(EduTeacher)表控制层
 *
 * @author mark
 * @since 2023-08-02 00:31:44
 */
@Tag(name = "EduTeacherController", description = "教师api")
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    /**
     * 服务对象
     */
    @Resource
    private EduTeacherService eduTeacherService;

    /**
     * 分页查询所有数据
     *
     * param page       分页对象
     * param eduTeacher 查询实体
     * @return 所有数据
     */
//    @GetMapping
//    public R selectAll(Page<EduTeacher> page, EduTeacher eduTeacher) {
//        return success(this.eduTeacherService.page(page, new QueryWrapper<>(eduTeacher)));
//    }
    @Operation(summary = "获取全部教师信息", description = "返回全体教师信息")
    @GetMapping()
    public List<EduTeacher> selectAll() {
        return eduTeacherService.list();
    }


//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("{id}")
//    public R selectOne(@PathVariable Serializable id) {
//        return success(this.eduTeacherService.getById(id));
//    }
//
//    /**
//     * 新增数据
//     *
//     * @param eduTeacher 实体对象
//     * @return 新增结果
//     */
//    @PostMapping
//    public R insert(@RequestBody EduTeacher eduTeacher) {
//        return success(this.eduTeacherService.save(eduTeacher));
//    }
//
//    /**
//     * 修改数据
//     *
//     * @param eduTeacher 实体对象
//     * @return 修改结果
//     */
//    @PutMapping
//    public R update(@RequestBody EduTeacher eduTeacher) {
//        return success(this.eduTeacherService.updateById(eduTeacher));
//    }
//
//    /**
//     * 删除数据
//     *
//     * @param idList 主键结合
//     * @return 删除结果
//     */
//    @DeleteMapping
//    public R delete(@RequestParam("idList") List<Long> idList) {
//        return success(this.eduTeacherService.removeByIds(idList));
//    }
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") String id) {
        return eduTeacherService.removeById(id);
    }

}
