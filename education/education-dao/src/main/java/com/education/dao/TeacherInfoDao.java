package com.education.dao;

import com.education.model.TeacherModel;
import java.util.List;


/**
 * 教师信息接口.
 * （数据层）
 * @author FYM
 *
 */
public interface TeacherInfoDao {

  /**
  * 根据学生id查询老师信息 .
  * @param stuId 学生id
  * @return 老师信息集合
  * @throws Exception 抛出异常
  */
  List<TeacherModel> getTeacherList(int stuId)throws Exception;
    
}
