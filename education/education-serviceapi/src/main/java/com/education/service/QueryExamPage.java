package com.education.service;
import com.education.model.ExamMessageModel;
import com.github.pagehelper.PageInfo;
/**
 * @author 考试信息接口
 *
 */
public interface QueryExamPage {
	/**
	 * @param pageNo 获取当前页数
	 * @param pageSize 获取一页有多少数据
	 * @return 分页实体
	 */
	PageInfo<ExamMessageModel>  pagenow( Integer pageNo, Integer pageSize)throws Exception;
     /**
      * @return int
      * @param el 传入考试信息
      * @throws Exceptio 抛出异常n
      */
    void addexam(ExamMessageModel el)throws Exception;
    
    /**
     * @param eid 传入的数据表的ID
     * @return 返回是否成功
     * @throws Exception 向上抛出异常
     */
    int  deleup(Integer eid)throws Exception;
}
