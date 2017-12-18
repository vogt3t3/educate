package com.education.service;

import com.education.model.User;
import com.github.pagehelper.PageInfo;

/**
 * 用户服务层接口
 * @author Administrator
 *
 */
public interface IUserService {
   /**
    *@param userName 用户姓名
    *@param pageNo 当前页
    *@param pageSize 总数据条数
    *@return PageInfo<User> 分页实体
    *@throws Exception 业务处理层异常
    */
    PageInfo<User> queryByPage(String userName, Integer pageNo, Integer pageSize) throws Exception;
}
