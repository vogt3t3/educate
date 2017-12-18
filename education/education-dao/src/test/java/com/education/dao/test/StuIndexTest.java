package com.education.dao.test;

import static org.junit.Assert.*;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.dao.StuIndexDao;
import com.education.model.CourseModel;
import com.education.model.StuIndexDo;


/**
 * 学生主页测试类
 * @author 刘帅
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class StuIndexTest {
    
    @Autowired
    private StuIndexDao stuIndex;
    
    @Test
    public void test() {
      
        List<StuIndexDo> courseList = stuIndex.queryCourse(1);
       
        System.out.println(courseList);
    }

}
