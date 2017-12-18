package com.education.student.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.StudentLoginModel;
import com.education.service.IStudentLoginService;

/**
 * 用户登录控制器
 * 
 * @author 杨振欣
 *
 */
@RequestMapping("/api/student")
@RestController
public class StudentLoginController {
	/**
	 * 注入学生登录业务层接口
	 */
	@Reference
	private IStudentLoginService studentLoginService;
	/**
	 * 学生登录实现
	 * @param loginModel 学生登录实体
	 * @return 统一返回值类型
	 * @throws Exception  抛出异常给全局异常处理
	 */
	@RequestMapping("/login")
	public ResultDo<Object> login(@RequestBody StudentLoginModel loginModel,HttpSession session) throws Exception {
		//登录处理
		ResultDo<Object> rs = studentLoginService.studentLogin(loginModel);
		//判断是否登陆成功
		if(rs.getResData()!=null){
			//添加新学生编号到session
				session.setAttribute("stuId", loginModel.getUsername());
				System.out.println(session.getAttribute("stuId")+"-----登录成功");
		}
		return rs;
	}
	/**
	 * 学生退出
	 * @param session session
	 * @return
	 */
	@RequestMapping("/logout")
	public ResultDo<Object> logout(HttpSession session){
		session.invalidate();
		ResultDo<Object> rs =new ResultDo<Object>();
		rs.setResCode(0);
		rs.setResData("学生退出成功");
		return rs;
	}
}
