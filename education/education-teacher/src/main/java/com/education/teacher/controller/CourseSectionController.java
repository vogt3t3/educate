package com.education.teacher.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.Judge;
import com.education.model.JudgeCourseSection;
import com.education.model.ResultDo;
import com.education.service.ICourseSectionApi;
import com.education.service.IEnrollServiceApi;
import com.github.pagehelper.PageHelper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/api/teacher", description = "判断题题库")
@RestController
@RequestMapping("/api/teacher")
public class CourseSectionController {
    
    @Reference
    private ICourseSectionApi icsa;
    
    /**章节测试页面数据包括下拉框等控制层
     * @param currentPage
     * @return
     * @throws Exception
     */
    @ApiOperation(notes = "/judgeSection/page", httpMethod = "GET", value = "章节测试题库")
    @RequestMapping(value="/judgeSection/page",method=RequestMethod.GET)
    public ResultDo<Object> getPage(Integer currentPage ,String searchMessage) throws Exception{
        currentPage = currentPage == null?1:currentPage;
      System.out.println("模糊信息"+searchMessage+"当前页"+currentPage);
        Map<Object,Object> map = icsa.getPage(currentPage,searchMessage);
        ResultDo<Object> result = new ResultDo<Object>();
        result.setResMsg("请求成功");
        result.setResCode(0);
        result.setResData(map);
        return result;
    }
    
    /**添加章节测试试题
     * @param jcs
     * @return
     * @throws Exception
     */
    @ApiOperation(notes = "/judgeSection/addjudge", httpMethod = "POST", value = "添加章节测试试题")
    @RequestMapping(value="/judgeSection/addjudge",method=RequestMethod.POST)
    public ResultDo<Object> addJudgeSection(@RequestBody JudgeCourseSection jcs) throws Exception{

        icsa.addCourseSectionService(jcs);
        ResultDo<Object> result = new ResultDo<Object>();
        result.setResMsg("请求成功");
        result.setResCode(0);
        return result;
    }
    
    /**添加期末测试试题
     * @param jcs
     * @return
     * @throws Exception
     */
    @ApiOperation(notes = "/judgeSection/addExam", httpMethod = "POST", value = "添加期末测试试题")
    @RequestMapping(value="/judgeSection/addExam",method=RequestMethod.POST)
    public ResultDo<Object> addJudgeExam(@RequestBody JudgeCourseSection jcs) throws Exception{

        icsa.addExamService(jcs);
        ResultDo<Object> result = new ResultDo<Object>();
        result.setResMsg("请求成功");
        result.setResCode(0);
        return result;
    }
    
    
    
    /**添加入学测试试题
     * @param jcs
     * @return
     * @throws Exception
     */
    @ApiOperation(notes = "/judgeSection/addEnter", httpMethod = "POST", value = "添加入学测试试题")
    @RequestMapping(value="/judgeSection/addEnter",method=RequestMethod.POST)
    public ResultDo<Object> addJudgeEnter(@RequestBody JudgeCourseSection jcs) throws Exception{
        icsa.addEnterService(jcs);
        ResultDo<Object> result = new ResultDo<Object>();
        result.setResMsg("请求成功");
        result.setResCode(0);
        return result;

    
    } 
    /**更新判断题
     * @param jcs
     * @return
     * @throws Exception
     */
    @ApiOperation(notes = "/judgeSection/update", httpMethod = "POST", value = "根据id查找判断题")
    @RequestMapping(value="/judgeSection/update",method=RequestMethod.POST)
    public ResultDo<Object> updateJudgeCourseSection(@RequestBody JudgeCourseSection jcs) throws Exception{
        
//       System.out.println("判断题名"+jcs.getJudgeName()+"ssssss"+jcs.getJudgeOne()+"判断题id"+jcs.getJudgeId());
        icsa.update(jcs);
        ResultDo<Object> result = new ResultDo<Object>();
        result.setResMsg("请求成功");
        result.setResCode(0);
        return result;
 
    }  
    /**删除判断题
     * @param jcs
     * @return
     * @throws Exception
     */
    @ApiOperation(notes = "/judgeSection/delete", httpMethod = "POST", value = "根据id查找判断题")
    @RequestMapping(value="/judgeSection/delete",method=RequestMethod.POST)
    public ResultDo<Object> deleteJudgeCourseSection(@RequestBody JudgeCourseSection jcs) throws Exception{
        
//       System.out.println("判断题id"+jcs.getJudgeId());
        icsa.delete(jcs.getJudgeId());
        ResultDo<Object> result = new ResultDo<Object>();
        result.setResMsg("请求成功");
        result.setResCode(0);
        return result;

    }  
}
