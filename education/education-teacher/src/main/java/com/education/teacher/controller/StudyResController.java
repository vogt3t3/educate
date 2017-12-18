package com.education.teacher.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResourceTCModel;
import com.education.model.StudyResourceModel;
import com.education.service.IStudyResService;
import com.education.model.ResultDo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 导学资源的控制层
 * @author 申忠正
 */
@Api(value = "/api/teacher", description = "导学资源的相关操作")
@Controller
@RequestMapping("/api/teacher")
public class StudyResController {
    /**
     * 注入导学资源的业务层
     */
    @Reference
    private IStudyResService iStudyResService;
    /**
     * 引入log4j日志记录
     */
    private static Logger logger = Logger.getLogger(StudyResController.class.getName());
    /**
     * 查询所有的资源
     * @return List
     * @throws Exception 
     */
    @ApiOperation(notes = "StudyResController/queryResource", httpMethod = "GET", value = "查询所有的导学资源信息")
    @RequestMapping(value="/StudyResController/queryResource",method=RequestMethod.GET)
    @ResponseBody
    public ResultDo<Object> selectStudyResource(int pageSize,int pageNum) throws Exception{
        ResourceTCModel resourceTCModel =new ResourceTCModel();       
        PageInfo<ResourceTCModel> pro = iStudyResService.selectStudyResource(resourceTCModel,pageNum,pageSize);
        List<ResourceTCModel> studyResourceList=pro.getList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list",studyResourceList);
        map.put("total",pro.getTotal());
        
        ResultDo<Object> res = new ResultDo<Object>();
        res.setResCode(0);
        res.setResData(map);
        return res;
    }
    
    /**
     * 增加资源
     * @return int 添加操作
     * @throws Exception 
     */
    @ApiOperation(notes = "StudyResController/addResource", httpMethod = "POST", value = "增加导学资源信息")
    @RequestMapping("/StudyResController/addResource")
    @ResponseBody
    public ResultDo<Object> addStudyResource(@RequestBody ResourceTCModel sr,HttpSession session) throws Exception{
        //课程并没有实际数据
        sr.setTeacherId(Integer.parseInt(session.getAttribute("teacherId").toString()));
 
        sr.setCourseId(1);      
        int result = iStudyResService.addStudyResource(sr);
        ResultDo<Object> res = new ResultDo<Object>();
        res.setResCode(0);
        return res;
    }
    
    /**
     * 删除资源
     * @return int 删除操作【更新】
     * @throws Exception 
     */ 
    @ApiOperation(notes = "StudyResController/deleteResource", httpMethod = "GET", value = "删除导学资源信息")
    @RequestMapping("/StudyResController/deleteResource")
    @ResponseBody
    public ResultDo<Object> deleteResource(int resourceId) throws Exception{
        //添加导学资源（传入一个StudyResourceModel对象）
        int result = iStudyResService.deleteResource(resourceId);
        ResultDo<Object> res = new ResultDo<Object>();
        res.setResMsg("删除成功");
        res.setResCode(0);
        res.setResData(result);
        logger.info("delete result = " + result);       
        return res;  
    }
    /**
     * 根据资源id 查询详情
     * @return 资源对象
     * @throws Exception 
     */
    @ApiOperation(notes = "StudyResController/queryResById", httpMethod = "GET", value = "根据资源id 查询导学资源信息")
    @RequestMapping("/StudyResController/queryResById")
    @ResponseBody
    public ResultDo<Object> queryResById(int resourceId) throws Exception{
        logger.info("queryResById");  
        ResourceTCModel resourceTCModel = iStudyResService.queryResById(resourceId);
        ResultDo<Object> res = new ResultDo<Object>();
        res.setResData(resourceTCModel);
        return res;
    }
    /**
     * 更新资源信息
     * @return int 更新 影响的行数
     * @throws Exception 
     */
    @ApiOperation(notes = "StudyResController/updateResource", httpMethod = "POST", value = "更新导学资源信息")
    @RequestMapping("/StudyResController/updateResource")
    @ResponseBody
    public ResultDo<Object> updateResource(@RequestBody StudyResourceModel srModel) throws Exception{
        int result = iStudyResService.updateResource(srModel);
        ResultDo<Object> res = new ResultDo<Object>();
        res.setResCode(0);
        return res;
    }
    
    
}