package com.edu.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 讲师(EduTeacher)表实体类
 *
 * @author mark
 * @since 2023-08-02 00:31:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduTeacher {
    @Schema(title = "讲师id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @Schema(title = "讲师姓名")
    private String name;

    @Schema(title = "讲师简介")
    private String intro;

    @Schema(title = "讲师资历,一句话说明讲师")
    private String career;

    @Schema(title = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @Schema(title = "讲师头像")
    private String avatar;

    @Schema(title = "排序")
    private Integer sort;

    @TableLogic //实现逻辑删除

    @Schema(title = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Boolean isDeleted;

    @TableField(fill = FieldFill.INSERT)
    @Schema(title = "创建时间")
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @Schema(title = "更新时间")
    private Date gmtModified;
}

