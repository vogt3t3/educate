package com.education.service.test;



import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.model.ResultDo;
import com.education.service.IStudentScoreService;

/**
 * @author ZHAORUN
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class StudentScoreServiceTest {

    @Autowired
    private IStudentScoreService studentScoreServiceImpl;

    @Test
    public void getListStudentSectioScoreTest() throws Exception {
        @SuppressWarnings("rawtypes")
        ResultDo res=studentScoreServiceImpl.getListStudentSectionScore(1, 1);
        System.out.println(res.getResData().toString());   
    }
    @Test
    public void getListStudentScoreTest() throws Exception{
    	
    	ResultDo res=studentScoreServiceImpl.getListStudentScore(1);
    	System.out.println(res.toString());
    }
}
