package com.education.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.education.dao.ChangeDao;
import com.education.model.TransactionModel;
import com.education.service.IChangeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author xyh
 *
 */
@Service
public class ChangeServiceImpl implements IChangeService {

	/**
	 * 注入数据层接口
	 */
    @Autowired
	private ChangeDao changeDao;

	/**
	 * 获取所有异动列表
	 * @param studentId 学生编号
	 * @param studentName 学生姓名
	 * @param pageNo
	 *            当前页
	 * @param pageSize
	 *            总数据条数
	 * @return PageInfo<TransactionModel>
	 * @throws Exception
	 *             抛出异常
	 */
    
    public PageInfo<TransactionModel> queryByPage(Integer studentId, String studentName, Integer pageNo,
			Integer pageSize) throws Exception {

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
		// 开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);
        List<TransactionModel> list = changeDao.queryChangeAll(studentId, studentName);
        PageInfo<TransactionModel> page = new PageInfo<TransactionModel>(list);

        return page;
    }

	/**
	 * 根据学生编号返回该生的异动
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
    @Override
	public PageInfo<TransactionModel> queryTranById(Integer studentId, Integer pageNo, Integer pageSize) throws Exception {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<TransactionModel> trlist = changeDao.queryTranById(studentId);
        PageInfo<TransactionModel> page = new PageInfo<TransactionModel>(trlist);
        return page;
    }

	/**
	 * 教师端删除异动
	 */
    @Override
	public int deleteChange(int transactionId) throws Exception {
        int result = changeDao.deleteChange(transactionId);
        return result;
    }

	/**
	 * 教师端更新异动
	 */
    @Override
	public int updateChange(TransactionModel tm) throws Exception {
        int count = changeDao.updateChange(tm);
        return count;
    }

	@Override
	public int addChange(TransactionModel tm) throws Exception {
		int result = changeDao.addChange(tm);
		return result;
	}
}
