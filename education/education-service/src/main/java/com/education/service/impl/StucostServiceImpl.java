package com.education.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.education.dao.StucostmanagerDao;
import com.education.model.StudentModel;
import com.education.model.StudentModelDate;
import com.education.service.IStucostSercive;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 学费管理服务层实现类
 * 
 * @author 周长磊
 *
 */
@Service
public class StucostServiceImpl implements IStucostSercive {

    /**
     * 注入学费管理接口
     */
    @Autowired
    private StucostmanagerDao stucostmanagerDao;

    /**
     * 查询学费信息（分页查询 + 模糊查询）
     * 
     * @param stu
     *            学费管理多条件查询实体
     * @param pageNo
     *            当前页
     * @param pageSize
     *            总数据条数
     * @return PageInfo<Student> 分页实体
     * @throws Exception
     *             业务处理层异常
     */
    public PageInfo<StudentModel> listStucostBy(StudentModelDate stu, Integer pageNo, Integer pageSize)
            throws Exception {

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        // 开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);

        // 返回查询结果
        List<StudentModel> list = stucostmanagerDao.listStucostBy(stu);

        // 将查询结果传给PageInfo对象
        PageInfo<StudentModel> pageInfo = new PageInfo<StudentModel>(list);
        return pageInfo;
    }

    /**
     * 未交学费【以现在时间减去入校时间算出应该交的学费】（人）
     * 
     * @param pageNo
     *            当前页
     * @param pageSize
     *            总数据条数
     * @return PageInfo<StudentModel> 分页实体
     * @throws Exception
     *             抛出异常
     */
    public PageInfo<StudentModel> listStucostUnpaid(Integer pageNo, Integer pageSize) throws Exception {

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        // 开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);

        // 返回查询结果
        List<StudentModel> list = stucostmanagerDao.listStucostUnpaid();

        // 将查询结果传给PageInfo对象
        PageInfo<StudentModel> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 更新学费记录（按学生编号）
     * 
     * @param stu
     *            学生表实体
     * @return int
     * @throws Exception
     *             抛出异常
     */
    public int updateStucostById(StudentModel stu) throws Exception {
        
        int record = stucostmanagerDao.updateStucostById(stu);
        return record;
    }

}
