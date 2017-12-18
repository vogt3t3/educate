package com.education.model;

import java.io.Serializable;

/**
 * 每个科目的章节
 * @author 赵京华
 */
public class TestOfSection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 课程的顺序号，需要自己编写
	 */
	private int num;
	/**
	 * 课程中章节的名称
	 */
	private String sectionName;
	/**
	 * 每个章节的考试状态
	 */
	private String testState;
	/**
	 * 每个章节的得分
	 */
	private int score;
	/**
	 * 章节的id
	 */
	private int sectionId;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getTestState() {
		return testState;
	}
	public void setTestState(String testState) {
		this.testState = testState;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	
}





















