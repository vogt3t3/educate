package com.education.service;

import java.util.List;
import com.education.exception.ServiceException;
import com.education.model.TeaEvaluationModel;

/**
 * 老师评价
 * （服务层）
 * @author FYM
 *
 */
public interface TeacherEvaluationService {
    /**
     * @param stuId 学生id
     * @param teaId 老师id
     * @return 教师评价的集合
     * @throws Exception 声明异常
     */
    List<TeaEvaluationModel> queryTeaEvaluationList( Integer stuId, Integer teaId) throws Exception;
    /**
     * 添加评价
     * @param teaEvaluationModel 传入教师评价对象
     * @return 影响的行数
     * @throws ServiceException 抛出异常
     */
   
    int addTeaEvaluation(TeaEvaluationModel teaEvaluationModel) throws ServiceException;
}
