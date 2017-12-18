package com.education.service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.model.CourseModel;
import com.education.model.ResultDo;
import com.education.model.StuIndexDo;
import com.education.service.IStuIndexService;
import com.github.pagehelper.PageInfo;

/**
 * 学生主页服务层测试
 * @author 刘帅
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class StuIndexTest {
    
    /**
     *学生主页 
     */
    @Autowired
    private IStuIndexService stuIndex;
    
    @Test
    public void test() {
       
        ResultDo<PageInfo<StuIndexDo>> resultDo = stuIndex.queryCourse(1,1,10);
        
        System.out.println(resultDo);
    }

}
