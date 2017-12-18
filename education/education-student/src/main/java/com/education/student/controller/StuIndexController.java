package com.education.student.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ClassEvaluate;
import com.education.model.CourseDo;
import com.education.model.PartSectionModel;
import com.education.model.ResultDo;
import com.education.model.SectionDo;
import com.education.model.StuIndexDo;
import com.education.model.VideoModel;
import com.education.service.ICourseInfoService;
import com.education.service.IEvaluateService;
import com.education.service.IPartSectionService;
import com.education.service.IPlayVideoService;
import com.education.service.IStuCourseService;
import com.education.service.IStuIndexService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 学生主页控制层
 * @author 刘帅
 *
 */
@Api(value = "/api/student", description = "学生端的相关操作")
@RequestMapping("/api/student")
@Controller
public class StuIndexController {

    /**
     * 日志记录类
     */
    private static Logger MYLOGGER = LogManager.getLogger(StuIndexController.class.getName());
    
    /**
     * 学生主页实现
     */
    @Reference
    private IStuIndexService stuIndexService;
    
    /**
     * 课程评价服务层
     */
    @Reference
    private IEvaluateService evaluateService;
    
    /**
     * 学习课程服务层
     */
    @Reference
    private IStuCourseService stuCourseService;
    
    /**
     * 小节服务层
     */
    @Reference
    private IPartSectionService partSectionService;
    
    /**
     * 课程详细信息
     */
    @Reference
    private ICourseInfoService courseInfo;
    
    /**
     * 播放视频
     */
    @Reference
    private IPlayVideoService playVideo;

    /**
     * 学生主页
     * @param pageSize  每页显示条数
     * @param currentPage 当前页
     * @return 返回学生所有课程
     */
    @ApiOperation(notes = "query", httpMethod = "GET", value = "返回学生所有课程")
    @RequestMapping(value="/query",method=RequestMethod.GET)
    @ResponseBody
    public ResultDo<PageInfo<StuIndexDo>> queryCourse(int pageSize,int currentPage) {
        
        MYLOGGER.info("每页条数"+pageSize+currentPage);
        ResultDo<PageInfo<StuIndexDo>> resultDo = new ResultDo<PageInfo<StuIndexDo>>();
        resultDo = stuIndexService.queryCourse(1, currentPage, pageSize);
        
        return resultDo;
    }
    
    /**
     * 课程评价
     * @param courseId课程编号
     * @param contents评价内容
     * @return 添加结果
     */
    @ApiOperation(notes = "addEvaluate", httpMethod = "GET", value = "添加课程评价")
    @RequestMapping("/addEvaluate")
    @ResponseBody
    public ResultDo<String> addEvaluate(int courseId,String contents) {
        
        ClassEvaluate evaluate = new ClassEvaluate();
        evaluate.setCourseId(courseId);
        evaluate.setClassEvaluateContent(contents);
        
        int flag = evaluateService.addEvaluate(evaluate);
        
        MYLOGGER.info(flag);
        MYLOGGER.info("课程编号"+courseId+contents);
        return null; 
    }
    
    /**
     * 学习课程
     * @param courseId 课程编号
     * @param pageSize  每页显示条数
     * @param currentPage 当前页
     * @return 返回该课程所有章节
     */
    @ApiOperation(notes = "sectionPage", httpMethod = "GET", value = "返回该课程所有章节")
    @RequestMapping("/sectionPage")
    @ResponseBody
    public ResultDo<PageInfo<SectionDo>> querySection(int courseId,int pageSize,int currentPage) {
        
        MYLOGGER.info("每页条数"+pageSize+currentPage);
        ResultDo<PageInfo<SectionDo>> resultDo = new ResultDo<PageInfo<SectionDo>>();
       
        resultDo = stuCourseService.querySection(courseId, currentPage, pageSize);
        
        return resultDo;
    }
    
    /**
     * 所有小节
     * @param sectionId 章节编号
     * @param pageSize 每页显示条数
     * @param currentPage 当前页
     * @return 返回该章节所有小节
     */
    @ApiOperation(notes = "stuCourse/detail", httpMethod = "GET", value = "返回该章节所有小节")
    @RequestMapping("/stuCourse/detail")
    @ResponseBody
    public ResultDo<PageInfo<PartSectionModel>> queryPartSection(int courseId,int pageSize,int currentPage) {
        
        //MYLOGGER.info("每页条数"+pageSize+currentPage);
        ResultDo<PageInfo<PartSectionModel>> resultDo = new ResultDo<PageInfo<PartSectionModel>>();
        //MYLOGGER.info("章节编号"+courseId);
        resultDo = partSectionService.queryCourse(courseId, currentPage, pageSize);
        
        return resultDo;
    }
    
    /**
     * 课程详细信息
     * @param partId 小节编号
     * @return 返回该小节对应的课程详细信息
     */
    @ApiOperation(notes = "getCourseInfo", httpMethod = "GET", value = "返回该小节对应的课程详细信息")
    @RequestMapping("/getCourseInfo")
    @ResponseBody
    public ResultDo<CourseDo> findCourseInfo(int partId) {
        
        MYLOGGER.info("章节编号"+partId);
        ResultDo<CourseDo> resultDo = new ResultDo<CourseDo>();
       
        resultDo = courseInfo.getCourseInfo(partId);
        
        return resultDo;
    }
    
    /**
     * 播放视频
     * @param partId 小节编号
     * @return 返回该小节对应的视频
     */
    @ApiOperation(notes = "getVideo", httpMethod = "GET", value = "返回该小节对应的视频")
    @RequestMapping("/getVideo")
    @ResponseBody
    public ResultDo<VideoModel> getVideo(int partId) {
        
        MYLOGGER.info("章节编号"+partId);
        ResultDo<VideoModel> resultDo = new ResultDo<VideoModel>();
       
        resultDo = playVideo.getVideo(partId);
        
        return resultDo;
    }
    
    
}
