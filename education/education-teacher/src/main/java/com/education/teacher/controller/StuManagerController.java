package com.education.teacher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.StudentModel;
import com.education.service.IStudentManagerService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 学生管理
 * 
 * @author 李梦鸽
 *
 */
@Api(value = "/api/admin", description = "教师端学生管理信息的相关操作")
@RequestMapping("/api/admin")
@Controller
public class StuManagerController {

	/**
	 * 注入学生的业务层
	 */
	@Reference
	private IStudentManagerService ims;

	/**
	 * 学生管理分页查询
	 * 
	 * @param studentName
	 *            姓名
	 * @param pageSize
	 *            每页显示条数
	 * @param pageNum
	 *            当前页
	 * @return ResultDo<Object> 
	 *            统一返回
	 * @throws Exception
	 *             异常抛出，交给全局异常处理器
	 */
	@ApiOperation(notes = "getPageStudents", httpMethod = "GET", value = "学生管理分页查询")
	@RequestMapping(value = "/StudentManager/getPageStudents", method = RequestMethod.GET)
	@ResponseBody()
	public ResultDo<Object> getPageStudents(String studentName,Integer studentId, Integer pageSize, Integer pageNum) throws Exception {
		// 调用教师服务层，进行分页查
		PageInfo<StudentModel> pageInfo = ims.getStudentListPage(studentName,studentId,pageSize, pageNum);
		// 将返回的分页查询结果(使用自定义返回类型ResultDo)返回给用户
		ResultDo<Object> rs = new ResultDo<Object>();
		rs.setResData(pageInfo);
		return rs;
	}

	/**
	 * 根据Id查询学生基本信息
	 * 
	 * @param studentId
	 *            学生编号
	 * @return ResultDo<Object> 
	 *            统一返回
	 * @throws Exception
	 *             异常抛出，交给全局异常处理器
	 */
	@ApiOperation(notes = "queryStuById", httpMethod = "GET", value = "根据Id查询学生基本信息")
	@RequestMapping(value = "/StudentManager/queryStuById", method = RequestMethod.GET)
	@ResponseBody()
	public ResultDo<Object> queryStuById(Integer studentId) throws Exception {
		StudentModel stuModel = ims.queryStuById(studentId);
		ResultDo<Object> rs = new ResultDo<Object>();
		rs.setResData(stuModel);
		return rs;
	}

	/**
	 * 根据Id查询学生详细信息
	 * 
	 * @param studentId
	 *            学生编号
	 * @return ResultDo<Object> 
	 *            统一返回
	 * @throws Exception
	 *             异常抛出，交给全局异常处理器
	 */
	@ApiOperation(notes = "getStudentDetail", httpMethod = "GET", value = "根据Id查询学生详细信息")
	@RequestMapping(value = "/StudentManager/getStudentDetail", method = RequestMethod.GET)
	@ResponseBody()
	public ResultDo<Object> getStudentDetail(Integer studentId) throws Exception {
		StudentModel stuDetail = ims.getStudentDetail(studentId);
		ResultDo<Object> rs = new ResultDo<Object>();
		rs.setResData(stuDetail);
		return rs;
	}

	/**
	 * 修改学生信息
	 * 
	 * @param studentModel
	 *            学生
	 * @return ResultDo<Object> 
	 *            统一返回
	 * @throws Exception
	 *             异常抛出，交给全局异常处理器
	 */
	@ApiOperation(notes = "updateStudent", httpMethod = "POST", value = "修改学生信息")
	@RequestMapping(value = "/StudentManager/updateStudents", method = RequestMethod.POST)
	@ResponseBody
	public ResultDo<Object> updateStudent(@RequestBody StudentModel studentModel) throws Exception {
		int stuMod = ims.updateStudent(studentModel);
		ResultDo<Object> rs = new ResultDo<Object>();
		rs.setResCode(stuMod);
		return rs;
	}

	/**
	 * 删除学生的某一条信息(修改状态)
	 * 
	 * @param StudentId
	 *            学生id
	 * @return ResultDo<Object> 
	 *            统一返回
	 * @throws Exception
	 *             异常抛出，交给全局异常处理器
	 */
	@ApiOperation(notes = "deleteStudent", httpMethod = "GET", value = "删除学生的某一条信息(修改状态)")
	@RequestMapping(value = "/StudentManager/deleteStudents", method = RequestMethod.GET)
	@ResponseBody()
	public ResultDo<Object> deleteStudent(Integer studentId) throws Exception {
		int deleteStu = ims.deleteStudent(studentId);
		ResultDo<Object> rs = new ResultDo<Object>();
		rs.setResData(deleteStu);
		return rs;
	}



}
