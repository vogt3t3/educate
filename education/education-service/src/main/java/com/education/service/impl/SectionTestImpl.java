package com.education.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.education.dao.SectionTestDao;
import com.education.model.SelectModel;
import com.education.model.TestOfCourse;
import com.education.model.TestOfSection;
import com.education.service.ISectionTest;
/**
 * 章节测试接口实现
 * @author 赵京华
 */
@Service
public class SectionTestImpl implements ISectionTest {
	/**
     * 注入数据层接口
     */
    @Autowired
    private SectionTestDao std;
    /**
     * 根据学生编号查询出该学生学习的课程
     * @param stuId 学生编号
     * @return List<TestOfCourse>
     * @throws Exception 抛出处理异常
     */
	@Override
	public List<TestOfCourse> getAllCourseByStuId(int stuId) throws Exception {
		System.out.println("进入到了后台service层");
		List<TestOfCourse> courseList=std.getCourseByStuId(stuId);
		return courseList;
	}
	/**
     * 根据传递过来的课程的编号查询该课程中章节的信息内容
     * @param courseId 课程的编号
     * @return List<TestOfSection> TestOfSection类型
     * @throws Exception 抛出底层异常
     */
	@Override
	public List<TestOfSection> getAllSectionByCourseId(int courseId) throws Exception {
		System.out.println("进入到了后台获取章节的考试信息");
		List<TestOfSection> sectionList=std.getSectionByCourseId(courseId);
		for(int i=0;i<sectionList.size();i++){
			sectionList.get(i).setNum(i+1);
			if(sectionList.get(i).getScore()<0){
				sectionList.get(i).setTestState("未通过测试");
			}else{
				sectionList.get(i).setTestState("已经通过测试");
			}
		}
		return sectionList;
	}
	/**
     * 根据章节的id号获取一张选择题的试卷
     * @param sectionId 章节的id
     * @return List<TestOfCourse>
     * @throws Exception 抛出处理异常
     */
	@Override
	public List<SelectModel> getSlectsPaper(int sectionId) throws Exception {
		//随机抽取试题
		List<SelectModel> allSelectList=std.getSlectPaper(sectionId);
		System.out.println("获取的全部选择题的数量："+allSelectList.size());
		int a =allSelectList.size();
		List set=new ArrayList();
		for(int i=0;i<10000;i++){
			int b=(int) Math.round(Math.random()*a);
			System.out.println("获取的随机数为："+b);
			if(!set.contains(b)){
				set.add(b);
				if(set.size()==10){
					break;
				}
			}	
		}
		List<SelectModel> selectList=new ArrayList<SelectModel>();
		for(int d=0;d<10;d++){
			selectList.add(allSelectList.get((int) set.get(d)));
			selectList.get(d).setSelectPoint(10);
		}
		return selectList;
	}
	@Override
	/**
     * 根据章节的id号和学生的id号向数据库中添加分数
     * @param sectionId 章节的id
     * @return List<TestOfCourse>
     * @throws Exception 抛出处理异常
     */
	public int saveSectionsScore(int sectionId, int stuId, int score) throws Exception {
		
		Integer a=std.getScore(sectionId, stuId);
		if(a==null || a==0){
			std.saveSectionScore(sectionId, stuId, score);
		}else{
			std.updateSectionScore(sectionId, stuId, score);
		}
		//根据章节的编号获取课程的编号
		int courseId=std.getCourseId(sectionId);
		//根据课程的编号求出该课程所有的章节数量
		Integer allSection=std.getAllSection(courseId);
		//根据课程编号和学员编号查询出该课程所有章节的分数的总和
		Integer allSectionScore=std.getSectionScoureSum(stuId, courseId);
		//算出平均成绩
		int sectionScoreAvg=Math.round(allSectionScore/allSection);
		//根据学号和课程编号查询是否存在这个成绩
		Integer scoreId=std.getScoureId(stuId, courseId);
		int afectnum=0;
		if(scoreId==null){
			afectnum=std.addSectionScoreToFanally(stuId, courseId, sectionScoreAvg);
		}else{
			afectnum=std.updateSectionScoreToFanally(stuId, courseId, sectionScoreAvg);
		}
		return afectnum;
	}
}














