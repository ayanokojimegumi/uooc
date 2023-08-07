package com.edu.entity.vo.chapter;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 小节类，用于存储章节中的课时信息
 * @author: mark
 * @create: 2023-08-07 15:08
 **/
@Data
public class VideoVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //视频id
    private String id;
    //视频标题
    private String title;
    //是否可以试听：0收费 1免费
    private String isFree;
}
