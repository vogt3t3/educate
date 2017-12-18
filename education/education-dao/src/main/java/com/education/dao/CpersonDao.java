package com.education.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.education.model.StudentEnterModel;
/**
 * @author 张露林dao接口
 *
 */
public interface CpersonDao {
	//预留部分审核人员审核所有学生(要用分页)
	List<StudentEnterModel> queryDentCheck();
	//审核人员查看所有学生信息要用分页
	List<StudentEnterModel> queryStudent();
	//审核人员的审核(根据id修改审核状态)
	int updateStudent(@Param(value="enterId") int enterId,@Param(value="enterCheckState") int enterCheckState);
	//审核人员根据id查看学生详细信息
	StudentEnterModel queryStudentDetails(int enterId);
	//审核人员部分的缴费部分
	List<StudentEnterModel> queryMoney();
	//审核人员部分的缴费详情部分 
	StudentEnterModel queryMoneyDetails(int enterId);
	//审核人员部分的入学成绩
	List<StudentEnterModel> queryGrade();
	//审核人员部分的入学成绩详情部分 
	StudentEnterModel queryGradeDetails(int enterId);
	//审核人员部分的历史记录
	List<StudentEnterModel> queryHistorical();
	//审核人员部分的历史记录详情部分 
	StudentEnterModel queryHistoricalDetails1(int enterId);
}
