package com.education.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dao.StudentScoreDao;
import com.education.model.ErrorCode;
import com.education.model.ResultDo;
import com.education.model.StudentScoreModel;
import com.education.service.IStudentScoreService;
import com.education.service.exception.ServiceException;

/**
 * 学生分数服务实现
 * 
 * @author ZHAORUN
 *
 */
@Service
public class StudentScoreServiceImpl implements IStudentScoreService {

    /**
     * 注入学生分数接口实例
     */
    @Autowired
    private StudentScoreDao studentScoreDao;

    @Override
    public ResultDo<List<StudentScoreModel>> getListStudentScore(int stuId) throws Exception {

        ResultDo<List<StudentScoreModel>> resultDo = new ResultDo<List<StudentScoreModel>>();
        // 查询学生课程分数
        List<StudentScoreModel> list = studentScoreDao.listStudentScore(stuId);
        if (list == null) {
            throw new ServiceException(ErrorCode.SERVER_ERROR);
        }
        resultDo.setResData(list);
        resultDo.setResCode(0);
        resultDo.setResMsg("获得学生各科成绩成功");
        return resultDo;
    }
    
    @Override
    public ResultDo<StudentScoreModel> getListStudentSectionScore(int stuId, int courseId) throws Exception {
        
        ResultDo<StudentScoreModel> resultDo = new ResultDo<StudentScoreModel>();
        // 查询学生课程分数组成
        StudentScoreModel scorelist = studentScoreDao.scoreGroup(stuId, courseId);
        if (scorelist == null) {
            throw new ServiceException(ErrorCode.SERVER_ERROR);
        }
        resultDo.setResData(scorelist);
        resultDo.setResCode(0);
        resultDo.setResMsg("获得学生课程分数组成成功");
        return resultDo;
    }

    @Override
    public ResultDo<String> doAddDissent(int stuId, int courseId, String content, Date date)
            throws Exception {
        ResultDo<String> resultDo = new ResultDo<String>();
        int num=studentScoreDao.addDissent(stuId, courseId, content, date);
        if(num>0){
            resultDo.setResCode(0);
            resultDo.setResMsg("成功");
        }else{
            resultDo.setResCode(-1);
            resultDo.setResMsg("失败");
        }
        return resultDo;
    }

}
