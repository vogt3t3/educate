package com.education.dao;

import com.education.exception.ServiceException;
import com.education.model.TeaEvaluationModel;
import java.util.List;
import org.apache.ibatis.annotations.Param;


/**
  * 教师评价接口.
  * (数据层)
  * @author FYM
  *
  */
public interface TeacherEvaluationDao {
  /**
  * 查询教师评价.
  * @param stuId 学生id
  * @param teaId 老师id
  * @return 教师评价对象集合
  * @throws Exception 抛出异常
  */
  List<TeaEvaluationModel> queryTeaEvaluationList(@Param("stuId") int stuId,
          @Param("teaId") int teaId) throws Exception;
  
  /**
  * 添加评价.
  * @param teaEvaluationModel 传入教师评价对象
  * @return 影响的行数
  * @throws ServiceException 抛出异常
  */
  int addTeaEvaluation(TeaEvaluationModel teaEvaluationModel) throws ServiceException;
}
