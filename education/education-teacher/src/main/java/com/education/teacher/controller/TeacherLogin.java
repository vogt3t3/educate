package com.education.teacher.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.TeacherLoginModel;
import com.education.model.User;
import com.education.service.ITeacherLoginService;

/**
 * 教师登陆控制层
 * 
 * @author 杨振欣
 *
 */
@Controller
public class TeacherLogin {
	@Reference
	private ITeacherLoginService teacherLoginService;

	/**
	 * @param request
	 *            请求错误信息
	 * @return 返回视图
	 * @throws Exception
	 *             抛出认证异常
	 */
	@ResponseBody
	@RequestMapping(value = "/teacherlogin", method = RequestMethod.POST)
	public ResultDo<Object> teacherLogin(@RequestBody User user,HttpServletRequest request) throws Exception {
		HttpSession session=request.getSession();
		ResultDo<Object> rs = new ResultDo<Object>();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try {
			SecurityUtils.getSubject().login(token);
		} catch (UnknownAccountException e) {
			rs.setResCode(100);
			rs.setResMsg("用户名不存在");
			return rs;
		} catch (IncorrectCredentialsException e) {
			rs.setResCode(100);
			rs.setResMsg("用户名/密码错误");
			return rs;
		}
		TeacherLoginModel teachermodel = teacherLoginService.teacherlogin(Integer.parseInt(user.getUsername()));
		ResultDo<Object> rss = new ResultDo<Object>();
		rss.setResCode(0);
		user.setPassword("");
		user.setRoleId(teachermodel.getRoleId());
		rss.setResData(user);
		session.setAttribute("teacherId", user.getUsername());
		System.out.println(session.getAttribute("teacherId").toString());
		return rss;
	}

	/**
	 * @return ResultDo<Object> 返回成功的登录信息
	 */
	@ResponseBody
	@RequestMapping(value = "/teacherlogout", method = RequestMethod.POST)
	public ResultDo<Object> successLogin() {
		ResultDo<Object> rs = new ResultDo<Object>();
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout();
			rs.setResCode(0);
			return rs;
		}
		rs.setResCode(100);
		rs.setResMsg("退出失败");
		return rs;
	}
}
