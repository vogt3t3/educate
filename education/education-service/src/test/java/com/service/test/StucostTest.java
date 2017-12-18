package com.service.test;

import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.education.model.StudentModel;
import com.education.model.StudentModelDate;
import com.education.service.IStucostSercive;
import com.education.util.DateUtil;
import com.github.pagehelper.PageInfo;

/**
 * 学费管理测试类
 * 
 * @author 周长磊
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class StucostTest {

    /**
     * 自动注入学费管理接口
     */
    @Autowired
    private IStucostSercive istucostSercive;

    /**
     * 多条件查询测试类
     * 
     * @throws Exception
     *             抛出异常
     */
    @Test
    public void test1() throws Exception {
        StudentModel stu = new StudentModel();
        // stu.setStudentId(40);
        // stu.setStudentName("mi");
        // stu.setStudentSex("女");
        // stu.setStuEducation("高中");
        System.out.println(stu);
        /*
         * PageInfo<StudentModel> pageInfo = istucostSercive.listStucostBy(stu,
         * null, null, 1, 10); for (StudentModel s : pageInfo.getList()) {
         * System.out.println(s.getStudentId() + "\t" + s.getStudentName()); }
         */
    }

    /**
     * 判断未交学费测试类
     * 
     * @throws Exception
     *             抛出异常
     */
    @Test
    public void test2() throws Exception {
        PageInfo<StudentModel> pageInfo = istucostSercive.listStucostUnpaid(1, 10);
        for (StudentModel s : pageInfo.getList()) {
            System.out.println(s.getStudentName() + "\t" + s.getFirstMoney());
        }
    }
    
    /**
     * 修改学费信息测试类
     * 
     * @throws Exception
     *             抛出异常
     */
    @Test
    public void test3() throws Exception {
        StudentModel stu = new StudentModel();
        stu.setFirstMoney(3000);
        stu.setFirstMoneyTime(DateUtil.formatString("2016-6-29", "yyyy-MM-dd"));
        stu.setSecondMoney(3300);
        stu.setSecondMoneyTime(new Date());
        stu.setModifyPerson("张三");
        stu.setStudentId(1);
        int record = istucostSercive.updateStucostById(stu);
        System.out.println(record);
    }
}
