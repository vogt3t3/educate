package com.education.teacher.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.PartSectionModel;
import com.education.model.ResultDo;
import com.education.model.ThesisDo;
import com.education.service.IThesisService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 论文管理
 * @author 刘帅
 *
 */
@Api(value = "api/teacher", description = "论文管理的相关操作")
@Controller
@RequestMapping("/api/teacher")
public class ThesisController {

    /**
     * 日志记录类
     */
    private static Logger MYLOGGER = LogManager.getLogger(ThesisController.class.getName());
    
    /**
     * 论文管理服务层
     */
    @Reference
    private IThesisService thesisManage;
    
    /**
     * 获取论文列表
     * @param pageSize 每页条数
     * @param currentPage 当前页
     * @return 论文列表
     */
    @ApiOperation(notes = "thesis/getThesis", httpMethod = "GET", value = "获取论文列表")
    @RequestMapping("/thesis/getThesis")
    @ResponseBody
    public ResultDo<PageInfo<ThesisDo>> queryPartSection(int pageSize,int currentPage) {
        
        //MYLOGGER.info("每页条数"+pageSize+currentPage);
        ResultDo<PageInfo<ThesisDo>> resultDo = new ResultDo<PageInfo<ThesisDo>>();
        //MYLOGGER.info("章节编号"+courseId);
        resultDo = thesisManage.getThesis(currentPage, pageSize);
        
        return resultDo;
    }
    
    /**
     * 添加成绩
     * @param thesisScore 论文成绩
     * @param thesisId  论文编号
     * @return
     */
    @ApiOperation(notes = "thesis/submitScore", httpMethod = "GET", value = "添加成绩")
    @RequestMapping("/thesis/submitScore")
    @ResponseBody
    public ResultDo<Integer> addScore(int thesisScore,int thesisId) {
        
        ResultDo<Integer> resultDo = thesisManage.addScore(thesisScore, thesisId);
        return resultDo;
    }
}
