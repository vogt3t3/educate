package com.education.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dao.CoursewareDao;
import com.education.dao.StudyResourceDao;
import com.education.model.Courseware;
import com.education.model.CoursewareResId;
import com.education.model.StudyResourceModel;
import com.education.service.ICoursewareService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 课件资源服务层服务
 * @author 申忠正
 *
 */
@Service
public class CoursewareImpl implements ICoursewareService{
    /**
     * 注入导学资源的数据层接口 StudyResourceDao
     */
    @Autowired 
    private CoursewareDao coursewareDao;
    /**
     *@param resourceId 根据资源id查询(如果资源id为空，则查询所有课件资源)
     *@param pageNo 当前页
     *@param pageSize 总数据条数
     *@return PageInfo<StudyResourceModel> 分页实体 【里面存放的是课件资源List】
     *@throws Exception 业务处理层异常
     */
    @Override
    public PageInfo<Courseware> queryCourseware(int resourceId,Integer pageNo, Integer pageSize) throws Exception {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        //开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);
        //查询结果返回
        List<Courseware> list = coursewareDao.queryCourseware(resourceId);
        //将查询结果传给PageInfo对象
        PageInfo<Courseware> page = new PageInfo<Courseware>(list);
        //打印PageInfo的各种使用方法
/*        System.out.println("当前页"+page.getPageNum());
        System.out.println("每页的条数"+page.getPageSize());
        System.out.println("开始位置"+page.getStartRow());
        System.out.println("结束位置"+page.getEndRow());
        System.out.println("总数据条数"+page.getTotal());
        System.out.println("总页数"+page.getPages());
        System.out.println("第一页"+page.getFirstPage());
        System.out.println("最后一页"+page.getLastPage());
        System.out.println("是否还有上一页"+page.isHasPreviousPage());
        System.out.println("是否还有下一页"+page.isHasNextPage());*/
        return page;
    }
    /**
     *@param  coursewareId 课件id
     *@return 影响的行数
     *@throws Exception 业务处理层异常
     */
    public int deleteCourseware(int coursewareId) throws Exception {
        int result = coursewareDao.deleteCourseware(coursewareId);
        return result;

    }
    @Override
    public int coursewareAdd(CoursewareResId courseware) {
        courseware.setCoursewareAddtime(new Date());
        courseware.setCoursewareSize(100);     
        int r = coursewareDao.coursewareAdd(courseware);
        return r;
    }
        
  
}
