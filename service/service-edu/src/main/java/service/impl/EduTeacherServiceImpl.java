package service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dao.EduTeacherDao;
import entity.EduTeacher;
import org.springframework.stereotype.Service;
import service.EduTeacherService;

/**
 * 讲师(EduTeacher)表服务实现类
 *
 * @author mark
 * @since 2023-08-02 00:31:45
 */
@Service("eduTeacherService")
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherDao, EduTeacher> implements EduTeacherService {

}

