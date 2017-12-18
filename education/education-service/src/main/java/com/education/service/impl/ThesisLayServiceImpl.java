package com.education.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dao.ThesisLayDao;
import com.education.model.ResultDo;
import com.education.model.ThesisDo;
import com.education.model.ThesisLayDo;
import com.education.service.IThesisLayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 论文规范服务层
 * @author 刘帅
 *
 */
@Service
public class ThesisLayServiceImpl implements IThesisLayService {
    
    /**
     * 注入论文规范数据层
     */
    @Autowired
    private ThesisLayDao thesisLay;
    
    /**
     * 日志记录类
     */
    private static Logger MYLOGGER = LogManager.getLogger(StuIndexServiceImpl.class);
    
    /**
     * 获得论文规范列表
     * @param pageNo 当前页
     * @param pageSize  每页多少条
     * @return  论文规范分页列表
     */
    public ResultDo<PageInfo<ThesisLayDo>> getThesisLay(Integer pageNo, Integer pageSize) {
        
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        
        //开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);
        
        List<ThesisLayDo> thesisLayList = thesisLay.getThesisLay();
        
        //将查询结果传给PageInfo对象
        PageInfo<ThesisLayDo> page = new PageInfo<ThesisLayDo>(thesisLayList);
        ResultDo<PageInfo<ThesisLayDo>> resultDo = new ResultDo<PageInfo<ThesisLayDo>>();
        resultDo.setResData(page);
        MYLOGGER.info(page.getPageNum());
        return resultDo;
    }

    /**
     * 添加论文规范
     * @param thesisLayDo 论文规范实体类
     * @return
     */
    public ResultDo<ThesisLayDo> addThesisLay(ThesisLayDo thesisLayDo) {
        
        //根据专业名称找到对应的编号
        int majorId = thesisLay.getThesisLayId(thesisLayDo.getMajorName());
        MYLOGGER.info("专业编号:"+majorId);
        thesisLayDo.setMajorId(majorId);
        //添加论文规范
        int flag = thesisLay.addThesisLay(thesisLayDo);
        MYLOGGER.info("论文规范编号:"+thesisLayDo.getLayoutId());
        //修改专业表中对应的论文规范编号
        int flags = thesisLay.updateMajor(thesisLayDo);
        MYLOGGER.info("修改专业表中对应的论文规范编号"+flags);
        ResultDo<ThesisLayDo> resultDo = new ResultDo<ThesisLayDo>();
        return resultDo;
    }

}
