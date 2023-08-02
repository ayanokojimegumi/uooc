package com.edu.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
/**
 * 教师查询条件(TeacherQuery)类
 * @author mark
 * @since 2023-08-02 00:31:45
 */
@Data
public class TeacherQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(title = "教师名称,模糊查询")
    private String name;

    @Schema(title = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    //注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    @Schema(title = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;

    @Schema(title = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
}
