package com.education.teacher.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.Education;
import com.education.model.MajorModel;
import com.education.service.EdService;
import com.education.model.ResultDo;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户的控制层
 * 
 * @author 徐鹏超
 *
 */
@Api(value = "/api/teacher/planManager", description = "教学计划的相关操作")
@Controller
@RequestMapping("/api/teacher/planManager")
public class EducationController {

	/**
	 * 日志生成
	 */
    private static Logger MYLOGGER = LogManager.getLogger(TeacherController.class.getName());

	/**
	 * 注入用户的业务层
	 */
    @Reference
	private EdService educationService;

	/**
	 * @param educationPlanId IntegerInteger
	 * @param majorName String
	 * @param pageNo Integer
	 * @param pageSize Integer
	 * @return String
	 * @throws Exception hhh
	 */
    @ApiOperation(notes = "getplanlist", httpMethod = "GET", value = "查询")
    @RequestMapping("/getplanlist")
	@ResponseBody
	public ResultDo<Object> getUser(Integer educationPlanId,String majorName,Integer pageNo, Integer pageSize) throws Exception {
        PageInfo<Education> page = educationService.queryByPage(educationPlanId,majorName,pageNo, pageSize);
        System.out.println(page);
        ResultDo<Object> res = new ResultDo<Object>();
        res.setResCode(0);
        res.setResData(page);

        return res;

    }
    /**
     * @param educationPlanId Integer
     * @return ResultDo<Object>
     * @throws Exception hh
     */
    @ApiOperation(notes = "queryId", httpMethod = "GET", value = "id查询")
	@RequestMapping("/queryId")
	@ResponseBody
	public ResultDo<Object> getEducationById(@RequestParam("educationPlanId") Integer educationPlanId)
			throws Exception {
        Education edu = educationService.getEducationById(educationPlanId);
        ResultDo<Object> rs = new ResultDo<Object>();
        System.out.println(edu);
        rs.setResData(edu);
		/* MYLOGGER.info(rs.getResData()); */
        return rs;
    }

    /**
     * @param education Education
     * @return ResultDo<Object>
     * @throws Exception gg
     */
    @ApiOperation(notes = "update", httpMethod = "POST", value = "修改")
	@RequestMapping("/update")
	@ResponseBody
	public ResultDo<Object> updataEducationPlan(@RequestBody Education education) throws Exception {

        System.out.println(education.getMajorName() + "\t" +education.getCourseName());
        int record = educationService.updataEducationPlan(education);
        ResultDo<Object> rs = new ResultDo<Object>();

        if (record > 0) {
            rs.setResCode(0);
            rs.setResMsg("修改成功");
        }
        return rs;

    }
    /**
	 * @param education Education
	 * @return ResultDo<Object>
	 * @throws Exception gg
	 */
    @ApiOperation(notes = "add", httpMethod = "POST", value = "增加")
	@RequestMapping("/add")
	@ResponseBody
	public ResultDo<Object> addEducationPlan(@RequestBody Education education) throws Exception {
        System.out.println(education.getMajorName() + "\t" +education.getCourseName());
        int record = educationService.addEducationPlan(education);
        ResultDo<Object> rs = new ResultDo<Object>();

        if (record > 0) {
            rs.setResCode(0);
            rs.setResMsg("增加成功");
        }
        return rs;

    }
    /**
     * @param educationPlanId Integer
     * @return ResultDo<Object>
     * @throws Exception gg
     */
    @ApiOperation(notes = "delPlan", httpMethod = "GET", value = "id删除")
	@RequestMapping("delPlan")
	@ResponseBody
	public ResultDo<Object> delEducationPlan(@RequestParam("educationPlanId") Integer educationPlanId) throws Exception {

        int record = educationService.delEducationPlan(educationPlanId);
        ResultDo<Object> rs = new ResultDo<Object>();

        if (record > 0) {
            rs.setResCode(0);
            rs.setResMsg("删除成功");
        }
        return rs;
    }
	
    /**
	 * @return ResultDo<Object>
	 * @throws Exception gg
	 */
    @ApiOperation(notes = "queryAdd", httpMethod = "GET", value = "下拉框查询")
	@RequestMapping("/queryAdd")
	@ResponseBody
	public ResultDo<Object> addMajorPlan() throws Exception {
        List<MajorModel> mm = educationService.addMajorPlan();

        ResultDo<Object> res = new ResultDo<Object>();
        res.setResCode(0);
        res.setResData(mm);

        return res;
    }
    /**
	 * @return ResultDo<Object>
	 * @throws Exception gg
	 */
    @ApiOperation(notes = "queryAdd1", httpMethod = "GET", value = "下拉框查询")
	@RequestMapping("/queryAdd1")
	@ResponseBody
	public ResultDo<Object> queryPlan() throws Exception {
        List<Education> mm = educationService.queryPlan();

        ResultDo<Object> res = new ResultDo<Object>();
        res.setResCode(0);
        res.setResData(mm);

        return res;
    }

}
