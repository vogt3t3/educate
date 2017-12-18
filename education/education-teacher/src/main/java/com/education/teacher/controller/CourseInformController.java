package com.education.teacher.controller;

import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.CourseInform;
import com.education.model.ResultDo;
import com.education.service.ICourseServiceApi;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 课程通知实例
 * @author 赵睿慷
 *
 */
@Api(value = "/api/course", description = "课程通知")
@Controller
@RequestMapping("/api/course")
public class CourseInformController {
    
    /**
     * 注入用户的业务层
     */
    @Reference
    private ICourseServiceApi icsc;
    
    /**
     * 引入log4j日志记录
     */
    private static Logger logger = Logger.getLogger(MajorContoroller.class.getName());
    
    /**
     * 查询
     * @param courseName 传入课程名称
     * @param informId   传入课程通知编号
     * @param pageSize   当前页条数
     * @param pageNum    当前页数
     * @return 所有数据
     */
    @ApiOperation(notes = "likeCourse", httpMethod = "GET", value = "查看课程通知信息，精确查询模糊查询")
    @RequestMapping(value="/likeCourse",method=RequestMethod.GET)
    @ResponseBody
    public ResultDo<PageInfo<CourseInform>> getCourseInform (String courseName,Integer informId,Integer pageSize,Integer pageNum){
        PageInfo<CourseInform> pageInfo=icsc.selectInformById(courseName,informId,pageNum,pageSize);
        ResultDo<PageInfo<CourseInform>> res = new ResultDo<PageInfo<CourseInform>>();
        res.setResData(pageInfo);
        return res;
    }
    
    /**
     * 删除信息
     * @param informId 课程管理通知
     * @return int.
     */
    @ApiOperation(notes = "remove", httpMethod = "GET", value = "删除课程通知信息")
    @RequestMapping(value="/remove",method=RequestMethod.GET)
    @ResponseBody
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResultDo delete(int informId){
        int del = icsc.deleteCourseById(informId);
        ResultDo rs = new ResultDo();
        if(del == 0){
            rs.setResData("删除失败");
        }
        else{
            rs.setResData("删除成功"+del);
        }
        return rs;
    }
    
    /**
     * 修改
     * @param courseInform 传入实体类对象
     * @param courseName   传入课程名称
     * @return int.
     */
    @ApiOperation(notes = "editCourse", httpMethod = "POST", value = "修改课程通知信息")
    @RequestMapping(value="/editCourse",method=RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResultDo update(@RequestBody CourseInform courseInform){
        System.out.println("CourseInformId:--------"+courseInform.getInformId());
        String  courseName = courseInform.getCourseName();
        //int a = icsc.selectCourseById(courseName);
        //courseInform.setCourseId(a);
        int update = icsc.updateCourseById(courseInform,courseName);
        System.out.println("CourseInform:--------"+update);
        ResultDo rs = new ResultDo();
        //查询出来的内容没有
        if(update == 0){
            rs.setResData("更新失败");
        }
        //有查询出来的内容
        else{
            rs.setResData("更新成功"+update);
        }
        return rs;
    }
    
    /**
     * 增加
     * @param courseInform 传入实体类对象
     * @return 参数.
     */
    @ApiOperation(notes = "add", httpMethod = "POST", value = "增加课程通知信息")
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResultDo add(@RequestBody CourseInform courseInform){
        int add = icsc.addCourseById(courseInform,courseInform.getCourseName());
        ResultDo rs = new ResultDo();
        if (add == 0) {
            rs.setResData("添加失败");
        }
        else {
            rs.setResData("添加成功"+add);
        }
        return rs;
    }
}
