package com.education.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.education.model.TransactionModel;

/**
 * @author xyh
 *
 */
public interface ChangeDao {

	/**
	 * 教师端查询所有学生的异动（分页查询 + 模糊查询）
	 * 
	 * @param studentId
	 *            学生编号
	 * @param studentName
	 *            学生姓名
	 * @return List<TransactionModel>
	 * @throws Exception
	 *             抛出异常
	 */
    List<TransactionModel> queryChangeAll(@Param("studentId") Integer studentId,
			@Param("studentName") String studentName) throws Exception;

	/**
	 * 学生端该生查询该生的所有异动
	 * 
	 * @param studentId
	 *            学生编号
	 * @return list
	 * @throws Exception
	 *             异常抛出
	 */
    List<TransactionModel> queryTranById(@Param("studentId") Integer studentId) throws Exception;

	/**
	 * 教师端异动删除
	 * 
	 * @param transactionId
	 *            异动编号
	 * @return 影响条数
	 * @throws Exception
	 *             抛出异常
	 */
    int deleteChange(int transactionId) throws Exception;

	/**
	 * 教师端更新异动
	 * 
	 * @param tm
	 *            异动实体类
	 * @return 影响条数
	 * @throws Exception
	 *             抛出异常
	 */
    int updateChange(TransactionModel tm) throws Exception;

    /**
     * 学生端增加异动
     * @param tm 异动实体类
     * @return 影响条数
     * @throws Exception 抛出异常
     */
    int addChange(TransactionModel tm) throws Exception;
    
}
