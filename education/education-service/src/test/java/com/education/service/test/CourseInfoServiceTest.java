package com.education.service.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.model.CourseDo;
import com.education.model.ResultDo;
import com.education.service.ICourseInfoService;

/**
 * 课程详细信息服务层测试
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class CourseInfoServiceTest {

    /**
     * 课程详细信息
     */
    @Autowired
    private ICourseInfoService courseInfo;
    
    @Test
    public void test() {
       
        
        ResultDo<CourseDo> course = courseInfo.getCourseInfo(1);
        
        System.out.println(course.getResData().getCourseName());
    }

}
