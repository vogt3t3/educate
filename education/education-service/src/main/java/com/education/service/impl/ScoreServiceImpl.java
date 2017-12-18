package com.education.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.education.dao.ScoreDao;
import com.education.exception.ServiceException;
import com.education.model.StudentScoreModel;
import com.education.service.ScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 成绩管理实现类
 * @author 冯云威
 *
 */
@Service
public class ScoreServiceImpl implements ScoreService{
    
    /**
     * 成绩管理数据层接口 
     */
    @Autowired
    private ScoreDao scoreDao;
    
    @Override
    public PageInfo<StudentScoreModel> queryByPage(Integer studentId, String studentName, Integer pageNo,
            Integer pageSize) throws Exception {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<StudentScoreModel> stuScoreList=scoreDao.stuScoreList(studentId, studentName);
        PageInfo<StudentScoreModel> page = new PageInfo<StudentScoreModel>(stuScoreList);
        return page;
    }

    @Override
    public StudentScoreModel getStuScore(Integer scoreId) throws Exception {
        StudentScoreModel stuScore=scoreDao.getStuScore(scoreId);
        return stuScore;
    }

    @Override
    public int updateScore(StudentScoreModel studentScoreModel) throws ServiceException{
        int count=scoreDao.updateScore(studentScoreModel);
        return count;
    }

    @Override
    public int addScore(StudentScoreModel studentScoreModel) throws Exception {
        int courseId=scoreDao.getcourseId(studentScoreModel.getCourseName());
        int studentId=scoreDao.getstuId(studentScoreModel.getStudentName());
        System.out.println(studentScoreModel.getCourseName());
        System.out.println(studentScoreModel.getStudentName());
        studentScoreModel.setCourseId(courseId);
        studentScoreModel.setStudentId(studentId);
        int count=scoreDao.addScore(studentScoreModel);
        return count;
    }

}
