package com.edu.controller;


import com.commonutils.R;
import com.edu.entity.EduTeacher;
import com.edu.entity.vo.TeacherQuery;
import com.edu.service.EduTeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


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
     * 模糊分页查询,根据name、level、时间，进行查询,并且将查询的结果进行分页
     * 如没有查询条件，将全部教师信息进行分页查询
     * @param page  当前页
     * @param limit 每页数据条数
     * @param teacherQuery  查询条件对象
     * @return  返回查询到的所有教师信息
     */
    @Operation(summary = "模糊分页查询", description = "根据name、level、时间，进行查询，" +
            "并且将查询的结果进行分页，如没有查询条件，将全部教师信息进行分页查询",
            parameters = {@Parameter(name = "page", description = "当前页"),
                          @Parameter(name = "limit", description = "每页数据条数"),
                          @Parameter(name = "teacherQuery", description = "查询条件对象")}
    )
    @ApiResponse(description = "返回查询到的教师信息，并进行分页", responseCode = "0/1 成功返回1，失败返回0")
    @GetMapping("/page")
    public R pageQuery(int page, int limit, TeacherQuery teacherQuery) {
        return this.eduTeacherService.pageQuery(page,limit, teacherQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Operation(summary = "根据主键查询",description = "根据接收的教师id，查询该教师的详细信息",
    parameters = {@Parameter(name = "id", description = "教师id")})
    @ApiResponse(description = "返回查询到的教师信息", responseCode = "0/1 成功返回1，失败返回0")
    @GetMapping("/{id}")
    public R selectOne(@PathVariable("id") String id) {
        EduTeacher teacher = this.eduTeacherService.getById(id);
        if (teacher != null) {
            return R.ok()
                    .data("teacher", teacher);
        }
        return R.error();
    }

    /**
     * 新增数据
     *
     * @param eduTeacher 实体对象
     * @return 新增结果
     */
    @Operation(summary = "新增教师", description = "根据接收的教师对象，新增教师",
    parameters = {@Parameter(name = "eduTeacher", description = "教师对象")})
    @ApiResponse(description = "返回一个R对象，包含状态码及详细信息", responseCode = "0/1 成功返回1，失败返回0")
    @PostMapping
    public R insert(@RequestBody EduTeacher eduTeacher) {
        this.eduTeacherService.save(eduTeacher);
        return R.ok();
    }

    /**
     * 修改数据
     *
     * @param eduTeacher 实体对象
     * @return 修改结果
     */
    @Operation(summary = "根据id修改教师信息",
              parameters = {@Parameter(name = "id", description = "教师id")})
    @ApiResponse(responseCode = "0/1 成功返回1，失败返回0",description = "返回一个R对象，包含状态码及详细信息")
    @PutMapping("/")
    public R update(@RequestBody EduTeacher eduTeacher) {
        this.eduTeacherService.updateById(eduTeacher);
        return R.ok();
    }


    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
@Operation(summary = "根据id删除教师信息",
        parameters = {@Parameter(name = "id", description = "教师id")})
@ApiResponse(responseCode = "0/1 成功返回1，失败返回0",description = "返回一个R对象，包含状态码及详细信息")
    @DeleteMapping("{id}")
    public R delete(@PathVariable("id") String id) {
        eduTeacherService.removeById(id);
        return R.ok();
    }

}

