package com.education.student.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.SelectModel;
import com.education.model.TestOfCourse;
import com.education.model.TestOfSection;
import com.education.service.ISectionService;
import com.education.service.ISectionTest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 单元测试控制层
 * @author 赵京华
 */
@Api(value = "/api/student", description = "单元测试")
@Controller
@RequestMapping("/api/student")
public class SectionTestController {
	@Reference
	private ISectionTest st;
	@Reference
	private ISectionService sections;
	/**
	 * 获取学生需要考试的课程
	 * @return ResultDo<StudentModel>
	 * @throws Exception 抛出异常
	 */
	@ApiOperation(notes = "sectionTest/testCourse", httpMethod = "POST", value = "获取学生需要考试的课程")
	@RequestMapping(value="/sectionTest/testCourse",method=RequestMethod.POST)
	@ResponseBody
	public ResultDo<Object> testCourse(HttpSession session) throws Exception{
		int userId=Integer.parseInt(session.getAttribute("stuId").toString());
		String username=sections.getTeacherById(userId);
		
		List<TestOfCourse> courseList=st.getAllCourseByStuId(userId);
		for(int i=0;i<courseList.size();i++){
			courseList.get(i).setCourseNum(i+1);
		}
		System.out.println(courseList.get(0).getCourseName());
		ResultDo<Object> rs=new ResultDo<Object>();
		rs.setResData(courseList);
		return rs;	
	}
	/**
	 * 获取学生的课程中需要进行测试的章节
	 * @return ResultDo<StudentModel>
	 * @throws Exception 抛出异常
	 */
	@ApiOperation(notes = "sectionTest/getSectionTest", httpMethod = "POST", value = "获取学生的课程中需要进行测试的章节")
	@RequestMapping(value="/sectionTest/getSectionTest",method=RequestMethod.POST)
	@ResponseBody
	public ResultDo<Object> testSection(@RequestBody Map<String,Object> map,HttpSession session) throws Exception{
		int courseId=(int) map.get("course_id");
		//System.out.println("获取到的课程的id编号为"+courseId);
		List<TestOfSection> sectionList=st.getAllSectionByCourseId(courseId);
		ResultDo<Object> rd=new ResultDo<Object>();
		rd.setResData(sectionList);
		return rd;
	}
	/**
	 * 生成试卷
	 * @return ResultDo<StudentModel>
	 * @throws Exception 抛出异常
	 */
	@ApiOperation(notes = "sectionTest/getTestPaperOfSection", httpMethod = "POST", value = "生成试卷")
	@RequestMapping(value="/sectionTest/getTestPaperOfSection",method=RequestMethod.POST)
	@ResponseBody
	public ResultDo<Object> getTestPaperOfSection(@RequestBody Map<String,Object> map) throws Exception{
		int sectionId=(int) map.get("section_id");
		System.out.println("获取的章节的id为："+sectionId);
		List<SelectModel> selectList=st.getSlectsPaper(sectionId);
		ResultDo<Object> rd=new ResultDo<Object>();
		rd.setResData(selectList);
		return rd;
	}
	/**
	 * 记录分数
	 * @return ResultDo<StudentModel>
	 * @throws Exception 抛出异常
	 */
	@ApiOperation(notes = "sectionTest/saveScoreOfSection", httpMethod = "POST", value = "记录分数")
	@RequestMapping(value="/sectionTest/saveScoreOfSection",method=RequestMethod.POST)
	@ResponseBody
	public ResultDo<Object> saveScoreOfSection(@RequestBody Map<String,Object> map,HttpSession session) throws Exception{
		System.out.println("后台的分数处理");
		int userId=Integer.parseInt(session.getAttribute("stuId").toString());
		//获取章节的编号
		int sectionId=(int) map.get("sec_Id");
		//System.out.println("获取到的章节的编号为："+sectionId);
		int SectionScore=(int) map.get("total");
		//System.out.println("获取分数："+SectionScore);
		int afectNum=st.saveSectionsScore(sectionId,userId, SectionScore);
		ResultDo<Object> rd=new ResultDo<Object>();
		if(afectNum!=0){
			rd.setResMsg("成功");
		}else{
			rd.setResMsg("失败");
		}
		return rd;
	}
}
