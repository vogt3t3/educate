package com.education.teacher.shiro;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.education.model.PermissionModel;
import com.education.service.ITeacherLoginService;
/**
 * 过滤链
 * @author Administrator
 *
 */
public class FilterChainDefinitionMapFactoryBean {
	/**
	 * log4j日志
	 */
	private static Logger logger = LogManager.getLogger(FilterChainDefinitionMapFactoryBean.class);
	/**
	 * 权限服务层接口
	 */
    @Autowired
    private ITeacherLoginService teacherLoginService;
	/**
	 * 过滤链map
	 * @return
	 */
	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("/js/**", "anon");
		map.put("/index.html", "anon");
		map.put("/teacherlogin ", "anon");
		map.put("/static/**", "anon");
		map.put("/images/**", "anon");
		map.put("/logout.action", "logout");
		map.put("/**", "authc");
		try {
			List<PermissionModel> list = teacherLoginService.listAllPermission();
			for(PermissionModel p:list){
				map.put(p.getPermissionUrl(), "authc,perms["+p.getPermissionCode()+"]");
			}
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		return map;
	}
}
