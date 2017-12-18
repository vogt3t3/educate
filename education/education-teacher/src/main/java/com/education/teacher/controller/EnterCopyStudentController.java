package com.education.teacher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.StudentEnterModel;
import com.education.service.IEnterCopyStudent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 张露林  预留部分审核通过的添加到学生表里
 *IEnterCopyStudent 服务层接口
 *EnterCopyStudentimpl  服务层接口的实现
 *EnterCopyStudent   dao接口
 *EnterCopyStudent.xml
 *
 */
@Api(value = "/api/teacher", description = "报名审核")
@Controller
@RequestMapping("/api/teacher")
public class EnterCopyStudentController {
	@Reference
	private IEnterCopyStudent admissions;
	/**
	 * @return String
	 * @author 预留部分审核通过的添加到学生表里
	 * 此方法参数类型有点问题
	 * @throws Exception
	 */
	@ApiOperation(notes = "/check/insertStudentTable", httpMethod = "GET", value = "审核人员的审核学生详情(根据id)")
    @RequestMapping(value="/check/insertStudentTable")
	@ResponseBody
	public int insertStudentTable(StudentEnterModel student) throws Exception {
		//此处有问题，前台的值传不过来，都为空
		int res = admissions.insertStuTable(student);
		return res;
	}
}
