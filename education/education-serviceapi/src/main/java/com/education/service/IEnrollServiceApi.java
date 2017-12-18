package com.education.service;


import java.util.Map;

import com.education.model.EnrollStudents;




/**招生计划的服务层
 * @author 李志鹏
 *
 */
public interface IEnrollServiceApi {
    
    
    /** 分页数据
     * @return EnrollStudentsModel实例化对象
     * @throws Exception
     */
    Map getEnrollS(Integer currentPage,Integer searchMessage)throws Exception;
    
    /**添加招生计划
     * @param enrollsStudents
     * @throws Exception
     */
    void addEnrolls(EnrollStudents enrollsStudents)throws Exception;
    
    
    /**根据id查询实例化对象
     * @param enroll_id
     * @return EnrollStudents实例化
     */
    EnrollStudents SelectEnroll(Integer enroll_id)throws Exception;
    
    
    /**更新数据
     * @param enrollsStudents
     * @throws Exception
     */
    void UpdateEnrolls(EnrollStudents enrollsStudents)throws Exception;
    
    /**更改招生信息的状态
     * @param enroll_id
     * @throws Exception
     */
    void DeleteEnroll(Integer enroll_id)throws Exception;
    
}
