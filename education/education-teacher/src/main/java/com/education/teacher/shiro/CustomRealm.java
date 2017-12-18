package com.education.teacher.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.education.model.TeacherLoginModel;
import com.education.service.ITeacherLoginService;

/**
 * @author 杨振欣
 *
 */
public class CustomRealm extends AuthorizingRealm {
    /**
     * 注入教师登陆的处理类
     */
    @Autowired
    private ITeacherLoginService teacherLoginService;

    /**
     * shiro权限的名称返回
     */
    @Override
    public String getName() {
        return "customRealm";
    }

    /**
     * 密码token返回
     */
    @Override
    public boolean supports(AuthenticationToken token){
        return token instanceof UsernamePasswordToken;
    }

    /**
     * shiro验证机制
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    	System.out.println(token.toString());
        String username = (String) token.getPrincipal();
        TeacherLoginModel teacher=null;
		try {
			teacher = teacherLoginService.teacherlogin(Integer.parseInt(username));
		} catch (Exception e) {
		}
        if (teacher == null) {
            return null;
        }
        String password = teacher.getTeacherPwd();
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(teacher, password, getName());
        return simpleAuthenticationInfo;
    }
    /**
     * shiro授权机制
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //添加指定权限
        TeacherLoginModel teacher =(TeacherLoginModel) principals.getPrimaryPrincipal();
        List<String> list=null;
        try {
			list=teacherLoginService.rolePermession(teacher.getRoleId());
		} catch (Exception e) {
			
		}
        for(String str:list){
        	 simpleAuthorizationInfo.addStringPermission(str);
        }
        return simpleAuthorizationInfo;
    }
	/**
	 * 清空缓存
	 */
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}

}
