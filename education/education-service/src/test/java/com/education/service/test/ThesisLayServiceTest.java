package com.education.service.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.model.ResultDo;
import com.education.model.ThesisLayDo;
import com.education.service.IThesisLayService;
import com.github.pagehelper.PageInfo;

/**
 * 论文规范测试类
 * @author 刘帅
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class ThesisLayServiceTest {
    
    /**
     * 论文规范服务层
     */
    @Autowired
    private IThesisLayService thesisLay;

    /**
     * 获得论文规范列表
     */
    @Test
    public void test() {
        
        ResultDo<PageInfo<ThesisLayDo>> resultDo = thesisLay.getThesisLay(1, 10);
        System.out.println(resultDo);
    }

    /**
     * 添加论文规范
     */
    @Test
    public void testAdd() {
        ThesisLayDo thesisLayDo = new ThesisLayDo();
        ResultDo<ThesisLayDo> resultDo = thesisLay.addThesisLay(thesisLayDo);
        System.out.println(resultDo);
    }
}
