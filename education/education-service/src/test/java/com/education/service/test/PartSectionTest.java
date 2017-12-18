package com.education.service.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.model.PartSectionModel;
import com.education.model.ResultDo;
import com.education.model.StuIndexDo;
import com.education.service.IPartSectionService;
import com.github.pagehelper.PageInfo;

/**
 * 小节服务层测试
 * @author 刘帅
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class PartSectionTest {
    
    /**
     * 小节服务层
     */
    @Autowired
    private IPartSectionService partSection;

    @Test
    public void test() {
        
        ResultDo<PageInfo<PartSectionModel>> resultDo = partSection.queryCourse(1, 1, 10);
        
        System.out.println(resultDo);
    }

}
