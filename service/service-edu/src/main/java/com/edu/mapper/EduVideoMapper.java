package com.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.entity.EduVideo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程视频(EduVideo)表数据库访问层
 *
 * @author mark
 * @since 2023-08-06 13:01:01
 */
@Mapper
public interface EduVideoMapper extends BaseMapper<EduVideo> {

}

