package com.education.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Reference;
import com.education.dao.CourseInfoDao;
import com.education.model.CourseDo;
import com.education.model.ResultDo;
import com.education.model.StuIndexDo;
import com.education.service.ICourseInfoService;
import com.github.pagehelper.PageInfo;

/**
 * 课程详细信息服务层
 * @author 刘帅
 *
 */
public class CourseInfoServiceImpl implements ICourseInfoService {
    
    /**
     * 课程信息数据层
     */
    @Autowired
    private CourseInfoDao courseInfo;
    
    /**
     * 日志记录类
     */
    private static Logger MYLOGGER = LogManager.getLogger(StuIndexServiceImpl.class);
    
    
    /**
     * 得到课程详细信息
     * @param partId 小节编号
     * @return  课程详细信息
     */
    public ResultDo<CourseDo> getCourseInfo(int partId) {
       
        CourseDo course = courseInfo.getCourseInfo(partId);
        
        ResultDo<CourseDo> resultDo = new ResultDo<CourseDo>();
        resultDo.setResData(course);
        
        MYLOGGER.info(course.getVideoName());
        return resultDo;
    }

}
