package com.education.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dao.StuIndexDao;
import com.education.model.ResultDo;
import com.education.model.StuIndexDo;
import com.education.service.IStuIndexService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * 学生主页
 * @author 刘帅
 *
 */
@Service
public class StuIndexServiceImpl implements IStuIndexService {

    /**
     * 学生主页接口
     */
    @Autowired
    private StuIndexDao stuIndex;
    
    /**
     * 日志记录类
     */
    private static Logger MYLOGGER = LogManager.getLogger(StuIndexServiceImpl.class);
    
    /**
     * 查询该学生的课程
     * @param 学生编号
     * @return 课程集合
     */
    public ResultDo<PageInfo<StuIndexDo>> queryCourse(int stuId,Integer pageNo, Integer pageSize) {
        
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        
        //开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);
        //查询该学生的课程
        List<StuIndexDo> courseList = stuIndex.queryCourse(1);
        
        //将查询结果传给PageInfo对象
        PageInfo<StuIndexDo> page = new PageInfo<StuIndexDo>(courseList);
        ResultDo<PageInfo<StuIndexDo>> resultDo = new ResultDo<PageInfo<StuIndexDo>>();
        resultDo.setResData(page);
        MYLOGGER.info(page.getPageNum());
        return resultDo;
    }

}
