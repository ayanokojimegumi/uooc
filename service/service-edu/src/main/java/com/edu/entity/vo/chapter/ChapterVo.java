package com.edu.entity.vo.chapter;

import com.edu.entity.vo.video.VideoVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 章节信息
 * @author: mark
 * @create: 2023-08-07 15:15
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //章节id
    private String id;
    //章节标题
    private String title;
    //章节视频
    private List<VideoVo> children = new ArrayList<>();

}
