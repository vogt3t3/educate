package com.education.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.education.dao.StudentDao;
import com.education.model.StudentModel;
import com.education.service.IStuMoneyService;

/**
 * 学生缴费业务层数据
 * @author 李梦鸽
 *
 */
@Service
public class StuMoneyServiceImpl implements IStuMoneyService{

	/**
	 * 学生缴费状态依赖注入StudentDao接口
	 */
	@Autowired
	private StudentDao sd;
	
	
	/**
	 * 查询学生的缴费状态
	 * 
	 * */
	@Override
	public List<StudentModel> getMoney(Integer studentId) throws Exception {
		
		StudentModel stuMoney=sd.getMoney(studentId);
		double firstmoney=stuMoney.getFirstMoney();
		double secondMoney=stuMoney.getSecondMoney();
		if(firstmoney==0){
			stuMoney.setFirstMoneyState("未交费");
		}else{
			stuMoney.setFirstMoneyState("已交费");
		}
		
		if(secondMoney==0){
			stuMoney.setSecondMoneyState("未交费");	
		}else{
			stuMoney.setSecondMoneyState("已交费");
		}
		List<StudentModel> list=new ArrayList<StudentModel>();
		list.add(stuMoney);
		return list;
		
	}
	
	/**
	 * 根据身份证缴费
	 * */
	@Override
	public StudentModel payMoney(String studentIdcard) throws Exception {
		StudentModel payMoney=sd.payMoney(studentIdcard);
		return payMoney;
	}
	
	/**
	 * 更新学生缴费信息
	 * @throws Exception 
	 * */
	@Override
	public int updateMoney(StudentModel studentModel) throws Exception {
		sd.updateMoney(studentModel);
		return 0;
	}


}
