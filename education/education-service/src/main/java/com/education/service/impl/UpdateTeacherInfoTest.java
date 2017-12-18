package com.education.service.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.education.dao.TeacherDao;
import com.education.model.TeacherModel;

/**
 * 更新指定教师测试类
 * 
 * @author ZHANGHENG
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml" })
public class UpdateTeacherInfoTest {
    
    @Autowired
    private TeacherDao td;
    
    /**
     * @throws Exception 
     * 
     */
    @Test
    public void getPageTeacherstest() throws Exception {
        TeacherModel teacherBean=new TeacherModel();
        teacherBean.setTeacherPwd("666");
        teacherBean.setTeacherRealName("天下第一");
     // TODO：调用数据层接口，更新教师信息
        int rsnums=td.updateTeacherInfo(teacherBean);
        System.out.println(rsnums);
        
        
    }

}
