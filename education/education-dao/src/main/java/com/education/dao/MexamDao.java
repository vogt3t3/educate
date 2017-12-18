package com.education.dao;

import java.util.List;

import com.education.model.ExamMessageModel;

/**
 *
 * @author 考试管理接口
 *
 */
public interface MexamDao {
    /**
     * 分页集合
     * @return 返回分页数据集合
     * @throws Exception 抛出的异常
     */
    List<ExamMessageModel> queryExam() throws Exception;
    /**
     * @return 返回值
     * @param em 传入实体类
     * @throws Exception 抛出的异常
     */
    int addResource(ExamMessageModel em) throws Exception;
    /**
     * @param eid 传入删除ID
     * @throws Exception 向上抛出异常
     */
    void deletExam(Integer eid) throws Exception;
}
