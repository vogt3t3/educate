package com.education.dao;

import java.util.List;

import com.education.model.StudentQuizModel;
import com.education.model.TeacherReplyModel;

/**
 * @author 视频答疑接口
 *
 */
public interface MvideoQuizDao {
    /**
     * 视频答辩分页
     * @return 分页集合
     * @throws Exception 向上抛出异常
     */
    List<StudentQuizModel> seleVideoQuiz() throws Exception;
    /**
     * @param st 已模糊查询信息内容
     * @return 分页几乎集合
     * @Exception 抛出异常 ss
     * @throws Exception 向上抛出异常
     */
    List<StudentQuizModel> seleMhoneVideoQuiz(String st) throws Exception;
    /**
     * 模糊查询id
     * @param it 模糊查询编号int
     * @return   返回分页集合 
     * @throws 向上抛出异常
     * @throws Exception 向上抛出异常
     */
    List<StudentQuizModel> seleQuizint(int it) throws Exception;
    /**
     * @param tl 传入老师回复表的值
     * @throws Exception 向上抛出异常
     */
    void updateVideoQuiz(TeacherReplyModel tl)throws Exception;
    /**
     * @param qid 传入id值
     * @throws Exception 向上抛出异常
     */
    void delVideoQuiz(Integer qid)throws Exception;
 
}
