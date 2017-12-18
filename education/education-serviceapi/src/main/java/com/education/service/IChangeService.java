package com.education.service;

import com.education.model.TransactionModel;
import com.github.pagehelper.PageInfo;

/**
 * @author xyh
 *
 */
public interface IChangeService {

	/**
	 * 教师端查询所有异动（模糊查询 + 分页）
	 * 
	 * @param studentId
	 *            学生编号
	 * @param studentName
	 *            学生姓名
	 * @param pageNo
	 *            分页
	 * @param pageSize
	 *            分页
	 * @return 分页实体类
	 * @throws Exception
	 *             抛出异常
	 */
    PageInfo<TransactionModel> queryByPage(Integer studentId, String studentName, Integer pageNo, Integer pageSize)
			throws Exception;

	/**
	 * 学生端根据学生编号返回该生的异动
	 * 
	 * @param studentId
	 *            学生的编号
	 * @param pageNo
	 *            分页
	 * @param pageSize
	 *            条数
	 * @return list
	 * @throws Exception
	 *             抛出异常
	 */
    PageInfo<TransactionModel> queryTranById(Integer studentId, Integer pageNo, Integer pageSize) throws Exception;

	/**
	 * 教师端删除异动
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
