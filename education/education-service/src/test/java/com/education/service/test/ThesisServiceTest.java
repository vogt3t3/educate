package com.education.service.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.model.ResultDo;
import com.education.model.ThesisDo;
import com.education.service.IThesisService;
import com.github.pagehelper.PageInfo;

/**
 * 论文管理测试类
 * @author 刘帅
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class ThesisServiceTest {
    
    /**
     * 论文管理服务层
     */
    @Autowired
    private IThesisService thesis;
    
    /**
     * 查看所有论文
     */
    @Test
    public void test() {
        
        ResultDo<PageInfo<ThesisDo>> resultDo = thesis.getThesis(1, 10);
        System.out.println(resultDo);
    }
    
    /**
     * 添加论文成绩
     */
    @Test
    public void testAdd() {
        
        ResultDo<Integer> resultDo = thesis.addScore(50, 1);
        System.out.println(resultDo);
    }

}
