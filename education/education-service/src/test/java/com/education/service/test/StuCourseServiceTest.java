package com.education.service.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.model.ResultDo;
import com.education.model.SectionDo;
import com.education.model.StuIndexDo;
import com.education.service.IStuCourseService;
import com.github.pagehelper.PageInfo;

/**
 * 学习课程测试类
 * @author 刘帅
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class StuCourseServiceTest {
    
    /**
     * 学习课程服务层
     */
    @Autowired
    private IStuCourseService stuCourse;
    
    @Test
    public void test() {
        
        ResultDo<PageInfo<SectionDo>> resultDo =stuCourse.querySection(1, 1, 5);
        
        System.out.println(resultDo);
    }

}
