package dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import entity.EduTeacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * 讲师(EduTeacher)表数据库访问层
 *
 * @author mark
 * @since 2023-08-02 00:31:45
 */
@Mapper
public interface EduTeacherDao extends BaseMapper<EduTeacher> {

}

