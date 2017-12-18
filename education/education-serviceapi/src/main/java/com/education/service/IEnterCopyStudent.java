package com.education.service;

import com.education.model.StudentEnterModel;
/**
 * @author 张露林招生人员的添加到学生表里服务层接口
 */
public interface IEnterCopyStudent {
	/**
	 * 预留部分审核通过的添加到学生表里
     *@return ResultDo<StudentEnterModel> 
     *@throws Exception 业务处理层异常
     */
	int insertStuTable(StudentEnterModel student) throws Exception;
}
