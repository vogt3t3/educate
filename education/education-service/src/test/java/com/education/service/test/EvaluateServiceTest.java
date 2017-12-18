package com.education.service.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.model.ClassEvaluate;
import com.education.service.impl.EvaluateServiceImpl;

/**
 * 课程评价测试
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class EvaluateServiceTest {

    /**
     * 课程评价服务层
     */
    @Autowired
    private EvaluateServiceImpl evaluateService;
    
    @Test
    public void test() {
        ClassEvaluate evaluate = new ClassEvaluate();
        int flag = evaluateService.addEvaluate(evaluate);
        System.out.println(flag);
    }

}
