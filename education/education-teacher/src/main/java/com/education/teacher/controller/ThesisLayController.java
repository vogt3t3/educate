package com.education.teacher.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.ThesisDo;
import com.education.model.ThesisLayDo;
import com.education.service.IThesisLayService;
import com.education.util.PropertiesUtil;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 论文规范
 * @author 刘帅
 *
 */
@Api(value = "api/teacher", description = "论文规范的相关操作")
@Controller
@RequestMapping("/api/teacher")
public class ThesisLayController {

    /**
     * 日志记录类
     */
    private static Logger MYLOGGER = LogManager.getLogger(ThesisController.class.getName());
    
    /**
     * 论文规范服务层
     */
    @Reference
    private IThesisLayService thesisLay;
    
    /**
     * 获得论文规范列表
     * @param pageSize 每页条数
     * @param currentPage 当前页
     * @return 论文规范列表
     */
    @ApiOperation(notes = "thesis/getThesisLay", httpMethod = "GET", value = "获得论文规范列表")
    @RequestMapping("/thesis/getThesisLay")
    @ResponseBody
    public ResultDo<PageInfo<ThesisLayDo>> queryPartSection(int pageSize,int currentPage) {
        
        MYLOGGER.info("每页条数"+pageSize+currentPage);
        ResultDo<PageInfo<ThesisLayDo>> resultDo = new ResultDo<PageInfo<ThesisLayDo>>();
        //MYLOGGER.info("章节编号"+courseId);
        resultDo = thesisLay.getThesisLay(currentPage, pageSize);
        
        return resultDo;
    }
    
    /**
     * 论文上传
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/thesis/impThesis",method = RequestMethod.POST)
    @ResponseBody
    public ResultDo<ThesisLayDo> upLoad(@RequestParam("cardXls") MultipartFile file,HttpServletRequest request,@RequestParam("major") String major) throws IOException {
        
        MYLOGGER.info("专业名称是:"+major);
        
        //String path = request.getSession().getServletContext().getRealPath("static");  
        
        String fileName = file.getOriginalFilename();
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(PropertiesUtil.doc+File.separator+ fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //String fileName = file.getOriginalFilename();  
        
        //System.out.println("路径:"+path);  
      
  
      
        ThesisLayDo thesisLayDo = new ThesisLayDo();
        //model.addAttribute("fileUrl", request.getContextPath()+"/static/"+fileName); 
        thesisLayDo.setMajorName(major);
        thesisLayDo.setLayoutName(fileName);
        thesisLayDo.setLayoutContent(PropertiesUtil.doc+File.separator+ fileName);
        //调用论文规范服务层
        thesisLay.addThesisLay(thesisLayDo);
        ResultDo<ThesisLayDo> resultDo = new ResultDo<ThesisLayDo>();
       
        return resultDo; 
    }
}
