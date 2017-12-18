package com.education.service;

import com.education.model.StudentModel;
import com.education.model.StudentModelDate;
import com.github.pagehelper.PageInfo;

/**
 * 学费管理服务层接口
 * 
 * @author 周长磊
 *
 */
public interface IStucostSercive {

    /**
     * 遍历学费信息（分页查询 + 模糊查询）
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
    PageInfo<StudentModel> listStucostBy(StudentModelDate stu, Integer pageNo, Integer pageSize) throws Exception;

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
    PageInfo<StudentModel> listStucostUnpaid(Integer pageNo, Integer pageSize) throws Exception;

    /**
     * 更新学费记录（按学生编号）
     * 
     * @param stu
     *            学生表实体
     * @return int
     * @throws Exception
     *             抛出异常
     */
    int updateStucostById(StudentModel stu) throws Exception;

}
