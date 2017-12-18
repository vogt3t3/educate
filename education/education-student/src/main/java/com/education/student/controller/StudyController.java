package com.education.student.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.StudyResourceModel;
import com.education.service.IStudyResourceApi;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 导学资源Controller层
 * @author 赵睿慷
 *
 */
@Api(value="/api/student",description="导学资源")
@Controller
@RequestMapping("/api/student")
public class StudyController {

    /**
     * 注入导学资源管理
     */
    @Reference
    private IStudyResourceApi study;
    
    /**
     * 查询
     * @param courseName 传入课程名称进行模糊查询
     * @param resourceId 传入导学资源ID进行精确查询
     * @param pageNum     当前页
     * @param pageSize   总数据条数
     * @return 所有数据.
     */
    @ApiOperation(notes="studys/study",httpMethod="GET",value="查询资源")
    @RequestMapping(path = "/studys/study" , method = RequestMethod.GET)
    @ResponseBody
    public ResultDo<Object> getStudy(String courseName, Integer resourceId, Integer pageSize,Integer pageNum) {
        // TODO Auto-generated method stub
        PageInfo<StudyResourceModel> page = study.getStudy(courseName, resourceId, pageNum,pageSize);
        List<StudyResourceModel> list = page.getList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list", list);
        map.put("total", page.getTotal());
        System.out.println("total----"+page.getTotal());
        System.out.println("list----"+list);
        ResultDo<Object> res = new ResultDo<Object>();
        res.setResData(map);
        return res;
    }
}
