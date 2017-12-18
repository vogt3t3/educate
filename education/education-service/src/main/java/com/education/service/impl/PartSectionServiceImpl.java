package com.education.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.education.dao.PartSectionDao;
import com.education.model.PartSectionModel;
import com.education.model.ResultDo;
import com.education.model.StuIndexDo;
import com.education.service.IPartSectionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author 刘帅
 *
 */
public class PartSectionServiceImpl implements IPartSectionService{
    
    /**
     * 小节数据层
     */
    @Autowired
    private PartSectionDao partSection;
    
    /**
     * 日志记录类
     */
    private static Logger MYLOGGER = LogManager.getLogger(StuIndexServiceImpl.class);
    
    /**
     * 查询该章节下的所有小节
     * @param sectionId 章节编号
     * @param pageNo 当前页
     * @param pageSize 数据条数
     * @return 小节集合
     */
    public ResultDo<PageInfo<PartSectionModel>> queryCourse(int sectionId, Integer pageNo, Integer pageSize) {
        
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        
        //开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);
        
        List<PartSectionModel> partList = partSection.queryPart(sectionId);
        
        //将查询结果传给PageInfo对象
        PageInfo<PartSectionModel> page = new PageInfo<PartSectionModel>(partList);
        ResultDo<PageInfo<PartSectionModel>> resultDo = new ResultDo<PageInfo<PartSectionModel>>();
        resultDo.setResData(page);
        MYLOGGER.info("当前页数"+page.getPageNum());
        
        return resultDo;
    }

}
