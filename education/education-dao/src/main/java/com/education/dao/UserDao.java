package com.education.dao;

import java.util.List;

import com.education.model.User;

/**
 * @author 杨振欣
 *
 */
public interface UserDao {
	
    /**
     * 
     * @param userName 传入用户的名称
     * @return List<User>
     * @throws Exception 抛出数据层异常
     */
    List<User> selectUserByUserName(String userName)throws Exception;
    
}
