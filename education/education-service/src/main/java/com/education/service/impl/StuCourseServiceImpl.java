package com.education.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dao.StuCourseDao;
import com.education.model.ResultDo;
import com.education.model.SectionDo;
import com.education.model.StuIndexDo;
import com.education.service.IStuCourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 学习课程实现类
 * @author 刘帅
 *
 */
@Service
public class StuCourseServiceImpl implements IStuCourseService {
    
    /**
     * 学习课程数据层接口
     */
    @Autowired
    private StuCourseDao stuCourse;
    
    /**
     * 日志记录类
     */
    private static Logger MYLOGGER = LogManager.getLogger(StuIndexServiceImpl.class);
    
    /**
     * 查询该课程所有章节
     * @param courseId 课程编号
     * @param pageNo 当前页
     * @param pageSize 数据条数
     * @return 带分页的所有章节
     */
    public ResultDo<PageInfo<SectionDo>> querySection(int courseId, Integer pageNo, Integer pageSize) {
        
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        
        //开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);
        
        //查询出所有的章节信息
        List<SectionDo> sectionList = stuCourse.querySection(courseId);
        
        //将查询结果传给PageInfo对象
        PageInfo<SectionDo> page = new PageInfo<SectionDo>(sectionList);
        ResultDo<PageInfo<SectionDo>> resultDo = new ResultDo<PageInfo<SectionDo>>();
        resultDo.setResData(page);
        MYLOGGER.info(page.getPageNum());
        return resultDo;
    }
    
    
}
