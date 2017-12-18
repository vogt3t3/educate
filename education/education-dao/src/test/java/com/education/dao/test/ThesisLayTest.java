package com.education.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.dao.ThesisLayDao;
import com.education.model.ThesisLayDo;

/**
 * 论文规范的测试
 * @author 刘帅
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class ThesisLayTest {

    /**
     * 论文规范数据层
     */
    @Autowired
    private ThesisLayDao thesisLay;
    
    /**
     * 获得论文规范列表
     */
    @Test
    public void test() {
        List<ThesisLayDo> thesisLayList = thesisLay.getThesisLay();
        System.out.println(thesisLayList);
    }
    
    /**
     * 添加论文规范
     */
    @Test
    public void testAdd() {
        ThesisLayDo thesisLayDo = new ThesisLayDo();
        
        int flag = thesisLay.addThesisLay(thesisLayDo);
        System.out.println(flag);
    }
    
    /**
     * 查询专业编号
     */
    @Test
    public void testMajor() {
        
        
       int majorId = thesisLay.getThesisLayId("计算机");
        System.out.println(majorId);
    }

}
