package com.education.teacher.controller;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.JudgeCourseSection;
import com.education.model.ResultDo;
import com.education.model.SelectExam;
import com.education.service.SelectExamApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "/api/teacher", description = "选择题题库")
@RestController
@RequestMapping("/api/teacher")
public class SelectExamController {
    
    @Reference
    private SelectExamApi sea;
    
    
    /**章节测试页面数据包括下拉框等控制层
     * @param currentPage
     * @return
     * @throws Exception
     */
    @ApiOperation(notes = "/selectSection/page", httpMethod = "GET", value = "默认页面数据")
    @RequestMapping(value="/selectSection/page",method=RequestMethod.GET)
    public ResultDo<Object> getPage(Integer currentPage ,String searchMessage) throws Exception{
        currentPage = currentPage == null?1:currentPage;
//        System.out.println("模糊信息"+searchMessage+"当前页"+currentPage);
        Map<Object,Object> map = sea.getPage(currentPage,searchMessage);
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
    @ApiOperation(notes = "/selectSection/addCourse", httpMethod = "POST", value = "添加章节测试试题")
    @RequestMapping(value="/selectSection/addCourse",method=RequestMethod.POST)
    public ResultDo<Object> addSelectSection(@RequestBody SelectExam se) throws Exception{
        sea.addCourseSection(se);
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
    @ApiOperation(notes = "/selectSection/addExam", httpMethod = "POST", value = "添加期末测试试题")
    @RequestMapping(value="/selectSection/addExam",method=RequestMethod.POST)
    public ResultDo<Object> addSelectExam(@RequestBody SelectExam se) throws Exception{

        sea.addExamService(se);
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
    @ApiOperation(notes = "/selectSection/addEnter", httpMethod = "POST", value = "添加入学测试试题")
    @RequestMapping(value="/selectSection/addEnter",method=RequestMethod.POST)
    public ResultDo<Object> addSelectEnter(@RequestBody SelectExam se) throws Exception{
        sea.addEnterText(se);
        ResultDo<Object> result = new ResultDo<Object>();
        result.setResMsg("请求成功");
        result.setResCode(0);
        return result;
    }
    /**更新选择题
     * @param jcs
     * @return
     * @throws Exception
     */
    @ApiOperation(notes = "/selectSection/update", httpMethod = "POST", value = "更新选择题")
    @RequestMapping(value="/selectSection/update",method=RequestMethod.POST)
    public ResultDo<Object> updateSelectExam(@RequestBody SelectExam se) throws Exception{
        
 //      System.out.println("用户名"+se.getSelectName()+);
        sea.update(se);
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
    @ApiOperation(notes = "/selectSection/delete", httpMethod = "POST", value = "根据id查找判断题")
    @RequestMapping(value="/selectSection/delete",method=RequestMethod.POST)
    public ResultDo<Object> deleteJudgeCourseSection(@RequestBody SelectExam se) throws Exception{
        
//       System.out.println("判断题id"+jcs.getJudgeId());
        sea.delete(se.getSelectId());
        ResultDo<Object> result = new ResultDo<Object>();
        result.setResMsg("请求成功");
        result.setResCode(0);
        return result;

    }  
    
    

    
    
}
