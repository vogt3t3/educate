package com.education.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.education.dao.TeacherEvaluationDao;
import com.education.exception.ServiceException;
import com.education.model.TeaEvaluationModel;
import com.education.service.TeacherEvaluationService;

/**
 * 实现类（服务层）
 * @author FYM
 *
 */
@Service
public class TeacherEvaluationServiceImpl implements TeacherEvaluationService{
    
    /**
     * 教师评价接口 
     */
    @Autowired
    private TeacherEvaluationDao teacherEvaluationDao;

    @Override
    public List<TeaEvaluationModel> queryTeaEvaluationList(Integer stuId, Integer teaId) throws Exception {
        List<TeaEvaluationModel> teaList=teacherEvaluationDao.queryTeaEvaluationList(stuId, teaId);
        return teaList;
    }
    
    @Override
    public int addTeaEvaluation(TeaEvaluationModel teaEvaluationModel) throws ServiceException {
        int count =teacherEvaluationDao.addTeaEvaluation(teaEvaluationModel);
        return count;
    }

    

}
