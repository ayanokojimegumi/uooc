package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.entity.EduChapter;
import com.edu.mapper.EduChapterMapper;
import com.edu.service.EduChapterService;
import org.springframework.stereotype.Service;

/**
 * 课程(EduChapter)表服务实现类
 *
 * @author mark
 * @since 2023-08-06 12:48:28
 */
@Service("eduChapterService")
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

}

