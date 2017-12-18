package com.education.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.education.model.MajorModel;
import com.education.service.IMajorServiceApi;
import com.github.pagehelper.PageInfo;

/**
 * 教师测试类
 * @author 赵睿慷
 *
 */

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:spring/spring.xml"})
public class TeacherTest {

    /**
     * 注入用户的业务层
     */
    @Autowired
    private IMajorServiceApi majorServiceApi;
    /**
     * 测试
     */
    @Test
    public void test() {
        
    }
    
    /**
     * 查询
     */
//    public void select(){
//        System.out.println("1111111111:"+majorServiceApi);
//        PageInfo<MajorModel> list=majorServiceApi.selectMajorByMajorid("lisi", 8, 6);
//        System.out.println(list.getList());
//    }

}
