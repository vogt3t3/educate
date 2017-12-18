/**
 * 
 */
package com.education.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.education.model.StudentModel;
import com.education.model.StudentModelDate;

/**
 * 学费管理接口
 * 
 * @author 周长磊
 *
 */
public interface StucostmanagerDao {

    /**
     * 查询学费信息（分页查询 + 模糊查询）
     * 
     * @param stu
     *            学费管理多条件查询实体
     * @return List<StudentModel>
     * @throws Exception
     *             抛出异常
     */
    List<StudentModel> listStucostBy(@Param("stu") StudentModelDate stu) throws Exception;

    /**
     * 未交学费【以现在时间减去入校时间算出应该交的学费】（人）
     * 
     * @return List<StudentModel>
     * @throws Exception
     *             抛出异常
     */
    List<StudentModel> listStucostUnpaid() throws Exception;

    /**
     * 更新学费记录（按学生编号）
     * 
     * @param stu
     *            学生表实体
     * @return int
     * @throws Exception
     *             抛出异常
     */
    int updateStucostById(@Param("stu") StudentModel stu) throws Exception;
}
