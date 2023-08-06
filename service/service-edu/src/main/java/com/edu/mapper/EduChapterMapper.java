package com.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.entity.EduChapter;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程(EduChapter)表数据库访问层
 *
 * @author mark
 * @since 2023-08-06 12:48:22
 */
@Mapper
public interface EduChapterMapper extends BaseMapper<EduChapter> {

}

