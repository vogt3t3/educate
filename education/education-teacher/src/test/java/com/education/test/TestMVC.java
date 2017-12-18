package com.education.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.model.User;
import com.education.service.IUserService;
import com.education.service.QueryExamPage;
import com.github.pagehelper.PageInfo;

/**
 * SpringNVC测试
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml" })
public class TestMVC {
    /**
     * 数据处理层接口
     */
    @Autowired
    private IUserService userservice;
    @Autowired
    private QueryExamPage qp;
    /** junit测试类
     * @throws Exception 异常抛出
     */
/*    @Test
    public void fenYe() throws Exception {
        PageInfo<User> list=userservice.queryByPage("lisi", 1, 5);
        System.out.println(list.getList());
    }*/
    
   @Test
     public void tt(){
    	 System.out.println(qp);
     }
}
