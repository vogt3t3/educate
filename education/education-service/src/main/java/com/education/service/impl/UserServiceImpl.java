package com.education.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.dao.UserDao;
import com.education.model.User;
import com.education.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 用户服务
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements IUserService{
    
    /**
     * 注入用户的数据层接口 userDao
     */
    @Autowired
    private UserDao userDao;
    
    /**
     * @param userName 用户名 
     * @param pageNo 当前页
     * @param pageSize 数据条数
     * @return PageInfo<User> 分页实体 
     * @throws Exception  
     */
    @Transactional
    public PageInfo<User> queryByPage(String userName, Integer pageNo, Integer pageSize) throws Exception{
      
    	
    	
    	pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        //开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);
        //查询结果返回
        List<User> list = userDao.selectUserByUserName("%"+userName+"%");
        //将查询结果传给PageInfo对象

        PageInfo<User> page = new PageInfo<User>(list);

        //打印PageInfo的各种使用方法

        System.out.println("当前页"+page.getPageNum());
        System.out.println("每页的条数"+page.getPageSize());
        System.out.println("开始位置"+page.getStartRow());
        System.out.println("结束位置"+page.getEndRow());
        System.out.println("总数据条数"+page.getTotal());
        System.out.println("总页数"+page.getPages());
        System.out.println("第一页"+page.getFirstPage());
        System.out.println("最后一页"+page.getLastPage());
        System.out.println("是否还有上一页"+page.isHasPreviousPage());
        System.out.println("是否还有下一页"+page.isHasNextPage());
        return page;
    }

}
