package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.mapper.EduVideoMapper;
import com.edu.entity.EduVideo;
import com.edu.service.EduVideoService;
import org.springframework.stereotype.Service;

/**
 * 课程视频(EduVideo)表服务实现类
 *
 * @author mark
 * @since 2023-08-06 13:01:01
 */
@Service("eduVideoService")
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

}

