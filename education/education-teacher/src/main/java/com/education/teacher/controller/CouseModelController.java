package com.education.teacher.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.CourseInform;
import com.education.model.CourseModel;
import com.education.service.ICoursesServiceApi;
import com.education.model.ResultDo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 课程管理
 * @author 赵睿慷
 *
 */
@Api(value = "api/teacher", description = "课程管理的相关操作")
@Controller
@RequestMapping("/api/teacher")
public class CouseModelController {

    /**
     * 注入用户的业务层
     */
    @Reference
    private ICoursesServiceApi icsa;
    
    /**
     * 引入log4j日志记录
     */
//    private static Logger logger = Logger.getLogger(MajorContoroller.class.getName());
    
    /**
     * 查询课程
     * @param courseName 传入课程名称
     * @param courseId   传入课程编号
     * @param pageSize   总页数
     * @param currentPage    当前页条数
     * @return 所有数据
     */
    @ApiOperation(notes = "course/likeCourse", httpMethod = "GET", value = "查询课程")
    @RequestMapping(path = "/course/likeCourse" , method = RequestMethod.GET)
    @ResponseBody
    public ResultDo<Object> getCourseInform (String courseName, Integer courseId, Integer currentPage, Integer pageSize){
        PageInfo<CourseModel> pageInfo=icsa.selectCourseById(courseName, courseId, currentPage, pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        ResultDo<Object> res = new ResultDo<Object>();
        res.setResData(map);
        return res;
    }
    
    /**
     * 删除信息
     * @param courseId 课程ID
     * @return int.
     */
    @ApiOperation(notes = "course/remove", httpMethod = "GET", value = "删除信息")
    @RequestMapping("/course/remove")
    @ResponseBody
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResultDo delete(int courseId){
        int del = icsa.delete(courseId);
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
     * @param courseModel 传入实体类对象
     * @return int.
     */
    @ApiOperation(notes = "course/editCourse", httpMethod = "POST", value = "修改")
    @RequestMapping(value="/course/editCourse", method = RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResultDo update(@RequestBody CourseModel courseModel){
        int update = icsa.update(courseModel);
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
     * @param courseModel 传入实体类对象
     * @return 参数.
     */
    @ApiOperation(notes = "course/add", httpMethod = "GET", value = "增加")
    @RequestMapping("/course/add")
    @ResponseBody
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResultDo add(@RequestBody CourseModel courseModel){
        int add = icsa.addCourse(courseModel, courseModel.getMajorName());
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
