package com.edu.entity.vo.video;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @description: 编辑课时基本信息的表单对象
 * @author: mark
 * @create: 2023-08-07 23:50
 **/
@Data

public class VideoInfoFormVo {
    @Schema(title = "视频id")
    private String id;
    @Schema(title = "视频标题")
    private String title;
    @Schema(title = "课程id")
    private String courseId;
    @Schema(title = "章节id")
    private String chapterId;
    @Schema(title = "课程id")
    private String videoSourceId;
    @Schema(title = "排序")
    private Integer sort;
    @Schema(title = "是否可以试听：0收费 1免费")
    private Boolean free;
}
