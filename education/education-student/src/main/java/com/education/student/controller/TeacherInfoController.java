package com.education.student.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.TeacherModel;
import com.education.service.TeacherInfoService;
import com.education.model.ResultDo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



/**
 * 教师信息
 * （控制层）
 * 返回数据
 * @author Administrator
 *
 */
@Api(value="/api/student",description="教师信息")
@RestController
@RequestMapping("/api/student")
public class TeacherInfoController{
    
    /**
     *服务层接口 
     */
    @Reference
    private TeacherInfoService teacherInfoService;

    /**
     * 向前端页面发送教师信息
     * @param stuId 学生Id
     * @param pageNo 当前页
     * @param pageSize 一页显示的条数
     * @return 该学生的教师的详细信息
     * @throws Exception 
     */
    @ApiOperation(notes="listTeacher",httpMethod="GET",value="向前端页面发送教师信息")
    @RequestMapping(path ="/listTeacher", method = RequestMethod.GET)
    public ResultDo<PageInfo<TeacherModel>> getTeacherInfoList(Integer stuId, @RequestParam("pageNum") Integer pageNo, Integer pageSize) throws Exception{
        PageInfo<TeacherModel> page=teacherInfoService.queryByPage(stuId, pageNo, pageSize);
        ResultDo<PageInfo<TeacherModel>> resultDo = new ResultDo<PageInfo<TeacherModel>>();
        resultDo.setResCode(0);
        resultDo.setResMsg("请求成功");
        resultDo.setResData(page);
        return resultDo;
    }
    
}
