package com.education.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dao.ManageThesisDao;
import com.education.model.ResultDo;
import com.education.model.StuIndexDo;
import com.education.model.ThesisDo;
import com.education.service.IThesisService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 论文管理服务层
 * @author 刘帅
 *
 */
@Service
public class ThesisServiceImpl implements IThesisService{
    
    /**
     * 注入论文管理数据层
     */
    @Autowired
    private ManageThesisDao manageThesis;
    
    /**
     * 日志记录类
     */
    private static Logger MYLOGGER = LogManager.getLogger(StuIndexServiceImpl.class);
    
    /**
     * 查询论文列表
     * @param pageNo 当前页
     * @param pageSize 每页显示条数
     * @return 论文列表
     */
    public ResultDo<PageInfo<ThesisDo>> getThesis(Integer pageNo, Integer pageSize) {
        
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        
        //开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);
        
        List<ThesisDo> thesisList = manageThesis.getThesis();
        for(ThesisDo thesis:thesisList) {
            if(thesis.getThesisState() == 0) {
                thesis.setThesisStateStr("未审核");
            }else if(thesis.getThesisState() == 1) {
                thesis.setThesisStateStr("已审核");
            }
        }
        //将查询结果传给PageInfo对象
        PageInfo<ThesisDo> page = new PageInfo<ThesisDo>(thesisList);
        ResultDo<PageInfo<ThesisDo>> resultDo = new ResultDo<PageInfo<ThesisDo>>();
        resultDo.setResData(page);
        MYLOGGER.info(page.getPageNum());
        return resultDo;
    }

    /**
     * 添加论文成绩
     * @param thesisScore 论文成绩
     * @param thesisId 论文编号
     * @return 影响行数
     */
    public ResultDo<Integer> addScore(int thesisScore,int thesisId) {
        
       int flag = manageThesis.addScore(thesisScore, thesisId);
       ResultDo<Integer> resultDo = new ResultDo<Integer>();
       resultDo.setResData(flag);
       return resultDo;
    }
}
