package com.education.service.test;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.education.dao.MajorDao;
import com.education.model.MajorModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 注解注入
 * @author 赵睿慷
 *
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:spring/spring.xml"})
public class SelectTest {

    
    /**
     * 注入MajorDao
     */
    @Autowired
    private MajorDao majorDao;
    /**
     * 测试注解
     */
    @Test
    public void test() {
//        select();
        //queryByPage("list", 1, 2);
        //selectById();
        //update();
        //delete();
        //add();
    }
    /** 
     * select测试类
     */
//    public void select(){
//        System.out.println("11111111111:"+majorDao);
//        System.out.println(majorDao.selectMajorByMajorid("11").toString());
//        List<MajorModel> list = majorDao.selectMajorByMajorid("list");
//        for (MajorModel majorModel : list) {
//            System.out.println(majorModel.toString());
//        }
//    }
      
 /**
 * @param majorName 传入的名字
 * @param pageNo 页数
 * @param pageSize 当前页数量
 * @return 参数
 */
//    public PageInfo<MajorModel> queryByPage(String majorName, Integer pageNo, Integer pageSize){
//        pageNo = pageNo == null?1:pageNo;
//        pageSize = pageSize == null?3:pageSize;
//        //开启分页 参数为当前页和数据条数
//        PageHelper.startPage(pageNo, pageSize);
//        //查询结果返回
//        List<MajorModel> list = majorDao.selectMajorByMajorid("%"+majorName+"%");
//        //将查询结果传给PageInfo对象
//        PageInfo<MajorModel> page = new PageInfo<MajorModel>(list);
//        //打印PageInfo的各种使用方法
//        System.out.println("当前页"+page.getPageNum());
//        System.out.println("每页的条数"+page.getPageSize());
//        System.out.println("开始位置"+page.getStartRow());
//        System.out.println("结束位置"+page.getEndRow());
//        System.out.println("总数据条数"+page.getTotal());
//        System.out.println("总页数"+page.getPages());
//        System.out.println("第一页"+page.getFirstPage());
//        System.out.println("最后一页"+page.getLastPage());
//        System.out.println("是否还有上一页"+page.isHasPreviousPage());
//        System.out.println("是否还有下一页"+page.isHasNextPage());
//        return page;
//    }
    
    /**
     * 增加测试
     */
    public void add(){
        MajorModel majorModel = new MajorModel();
        majorModel.setMajorName("上海");
        majorModel.setMajorAcademic("4");
        majorModel.setMajorDate(new Date());
        majorModel.setMajorProfile("练习");
        majorModel.setMajorCredit(300);
        majorModel.setMajorDelete(1);
        System.out.println(majorDao.addMajorByMajorid(majorModel));
        
    }
    
    /**
     * 通过id进行查找
     */
//    public void selectById(){
//        MajorModel majorModel = new MajorModel();
//        majorModel.setMajorName("赵睿慷");
//        MajorModel count = majorDao.getById(5);
//        System.out.println(count);
//       
//    }
//   
    /**
     * 修改
     */
    public void update(){
        MajorModel majorModel = new MajorModel();
        majorModel.setMajorId(1);
        majorModel.setMajorName("Java");
        majorModel.setMajorProfile("练习");
        majorModel.setMajorAcademic("4");
        majorModel.setMajorCredit(300);

        int count = majorDao.updateMajorByMajorid(majorModel);
        System.out.println(count);
        System.out.println(majorModel.getMajorName());
        System.out.println(majorModel.getMajorId());
    }
    /**
     * 删除
     */
    public void delete(){
        majorDao.deleteMajorById(34);
    }
    

}
