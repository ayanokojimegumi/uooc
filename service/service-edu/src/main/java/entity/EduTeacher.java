package entity;

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
    //讲师ID
    private String id;
    //讲师姓名
    private String name;
    //讲师简介
    private String intro;
    //讲师资历,一句话说明讲师
    private String career;
    //头衔 1高级讲师 2首席讲师
    private Integer level;
    //讲师头像
    private String avatar;
    //排序
    private Integer sort;
    //逻辑删除 1（true）已删除， 0（false）未删除
    private Boolean isDeleted;
    //创建时间
    private Date gmtCreate;
    //更新时间
    private Date gmtModified;
}

