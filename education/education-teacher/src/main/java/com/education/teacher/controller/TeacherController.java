package com.education.teacher.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.TeacherModel;
import com.education.service.ITeacherService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 教师控制层，提供教师服务
 * 
 * @author ZHANGHENG
 * @param <T>
 *
 */
@Api(value = "/api/admin", description = "教师管理的相关操作")
@Controller
@RequestMapping("/api/admin")
public class TeacherController<T> {
	/**
	 * 注入教师的业务层
	 */
	@Reference
	private ITeacherService its;

	/**
	 * 引入log4j日志记录
	 */
	private static Logger logger = Logger.getLogger(TeacherController.class.getName());

	/**
	 * 教师管理分页查询
	 * 
	 * @return
	 */
	@ApiOperation(notes = "TeachermangerFy", httpMethod = "GET", value = "获取教师的信息")
	@RequestMapping(path = "/TeachermangerFy", method = RequestMethod.GET)
	@ResponseBody
	public ResultDo<PageInfo<TeacherModel>> getPageTeachers(Integer teacherId, String teacherRealName,
			@RequestParam("pageNum") Integer pageNo, Integer pageSize) {
		logger.info(its);
		logger.info("这里是admin页面");
		PageInfo<TeacherModel> pageInfo = its.getPageTeachers(teacherId, teacherRealName, pageNo, pageSize);
		ResultDo<PageInfo<TeacherModel>> rs = new ResultDo<PageInfo<TeacherModel>>();
		rs.setResCode(0);
		rs.setResMsg("提交成功");
		rs.setResData(pageInfo);
		return rs;
	}

	/**
	 * 获取教师角色的信息
	 * 
	 * @return 教师角色列表
	 */
	@ApiOperation(notes = "roleDesc", httpMethod = "GET", value = "获取教师角色的信息")
	@RequestMapping(path = "/roleDesc", method = RequestMethod.GET)
	@ResponseBody
	public ResultDo<List<String>> getRole() {
		ResultDo<List<String>> rs = new ResultDo<List<String>>();
		List<String> roleDescList = its.getRole();
		rs.setResData(roleDescList);
		return rs;
	}

	/**
	 * 更改指定的教师信息
	 * 
	 * @return
	 */
	@ApiOperation(notes = "TeachermangerFyqx", httpMethod = "POST", value = "修改教师的信息")
	@RequestMapping(path = "/TeachermangerFyqx", method = RequestMethod.POST)
	@ResponseBody
	public ResultDo<T> updateTeacherInfo(@RequestBody TeacherModel teacherBean) {
		int rsnums = its.updateTeacherInfo(teacherBean);
		logger.info("这是影响行数" + rsnums);
		ResultDo<T> rs = new ResultDo<T>();
		rs.setResCode(0);
		rs.setResMsg("修改成功");
		return rs;
	}

	/**
	 * 删除指定教师
	 * 
	 * @return
	 */
	@ApiOperation(notes = "TeachermangerFyxy", httpMethod = "GET", value = "删除教师的信息")
	@RequestMapping(path = "/TeachermangerFyxy", method = RequestMethod.GET)
	@ResponseBody
	public ResultDo<T> delTeacher(Integer teacherId) {
		logger.info("这里是删除指定教师页面");
		int rsnums = its.delTeacher(teacherId);
		ResultDo<T> rs = new ResultDo<T>();
		rs.setResCode(0);
		rs.setResMsg("删除成功");
		return rs;
	}

	/**
	 * 新增教师
	 * 
	 * @return
	 */
	@ApiOperation(notes = "TeachermangerFi", httpMethod = "POST", value = "添加教师的信息")
	@RequestMapping(path = "/TeachermangerFi", method = RequestMethod.POST)
	@ResponseBody
	public ResultDo<T> insertTeacher(@RequestBody TeacherModel teacherBean) {
		int rsnums = its.insertTeacher(teacherBean);
		ResultDo<T> rs = new ResultDo<T>();
		rs.setResCode(0);
		rs.setResMsg("添加成功");
		return rs;

	}

}
