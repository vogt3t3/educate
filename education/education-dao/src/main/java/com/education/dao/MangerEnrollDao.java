package com.education.dao;

import java.util.List;

import com.education.model.EnrollStudents;
import com.education.model.MajorModel;

/**
 * 招生计划接口
 * @author 李志鹏
 *
 */

public interface MangerEnrollDao {
    
    /**根据当前页查出分页数据
     * @return获得所有招生计划学生的信息(分页数据)
     * @throws Exception 抛出业务层异常
     */
    List<EnrollStudents> queryEnrollStudent(Integer searchMessage)throws Exception;
    
    /**
     * 找出所有商品的条数
     * @return返回数据总条数
     * @throws Exception 抛出业务层异常
     */
    int getCountEnroll()throws Exception;
    
    
    /**增加招生计划
     * @param enrollsStudents 
     * @return 返回添加影响行数
     * @throws Exception 抛出业务层异常
     */
    int addEnroll(EnrollStudents enrollsStudents )throws Exception;
    
    
    
    /**更新根据id显示要更新的对应的招生信息
     * @param enrollStudentId招生id 
     * @return EnrollStudents对象，根据id查询返回对象
     * @throws Exception 抛出业务层异常
     */ 
    EnrollStudents queryEnrollStudentId(int enrollStudentId)throws Exception;
    
    
    
    /**更新招生计划
     * @param EnrollStudentsModel对象
     * @return 更新影响行数
     * @throws Exception 抛出业务层异常
     */
    int updateEnrollStudent(EnrollStudents enrollStudents)throws Exception;
    
    
    
    /**删除更新
     * @param enrollStudentId招生id
     * @return 影响行数
     * @throws Exception 抛出业务层异常
     */
    int deleteEnrollStudent(int enrollStudentId)throws Exception;
    
    
    
    
    /**下拉框信息
     * @return 返回MajorModel对象
     * @throws Exception 抛出数据层异常
     * @throws Exception 抛出业务层异常
     */
    List<MajorModel> queryMajorModel()throws Exception;
    
    
    
    
    
    
    
}
