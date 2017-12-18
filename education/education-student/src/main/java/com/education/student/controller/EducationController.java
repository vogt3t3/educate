package com.education.student.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.Education;
import com.education.service.EducationService;
import com.education.model.ResultDo;
import com.github.pagehelper.PageInfo;

/**
 * 用户的控制层
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/api/student/planManager")
public class EducationController {
	/**
	 * 日志生成
	 */
    private static Logger MYLOGGER = LogManager.getLogger(StudentController.class.getName());
	/**
	 * 注入用户的业务层
    */
    @Reference
	private EducationService educationService;

	
    /**
     * @param pageNo Integer
     * @param pageSize Integer
     * @return String
     * @throws Exception hhh
     */
    @RequestMapping("/getplanlist")
    @ResponseBody
    public ResultDo<Object> getUser(Integer pageNo, Integer pageSize) throws Exception {
    	System.out.println("pageNo "+pageNo + "/t" + "pageSize "+pageSize );
        PageInfo<Education> page = educationService.queryByPage(pageNo, pageSize);
        
        ResultDo<Object> res =new ResultDo<Object>();
        res.setResCode(0);
        res.setResData(page);
        
        return res;
        

    }

}
