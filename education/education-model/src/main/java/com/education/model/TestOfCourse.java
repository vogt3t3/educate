package com.education.model;

import java.io.Serializable;

/**
 * 学生学习的科目
 * @author 赵京华
 *
 */
public class TestOfCourse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 课程的顺序号，需要自己编写
	 */
	private int courseNum;
	/**
	 * 课程的名称，从数据库中取
	 */
	private String courseName;
	/**
	 * 每个课程中的章节数量
	 */
	private int sectionNum;
	/**
	 * 课程的课程id编号
	 */
	private int courseId;
	
	public int getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getSectionNum() {
		return sectionNum;
	}
	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
}
