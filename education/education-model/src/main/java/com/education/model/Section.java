package com.education.model;

import java.io.Serializable;
import java.util.Date;

import com.education.util.DateUtil;

/**
 * 课程章节
 * 
 * @author ZHAORUN
 *
 */
public class Section implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 章节编号
     */
    private Integer sectionId;
    /**
     * 章节名称
     */
    private String sectionName;
    /**
     * 章节添加时间
     */
    private Date sectionAddTime;
    /**
     * 章节添加时间
     */
    private String strSectionAddTime;
    /**
     * 章节修改人
     */
    private String seModifyPerson;
    /**
     * 章节修改时间
     */
    private Date sectionModifyDate;
    /**
     * 章节修改时间字符串
     */
    private String strSeModifyDate;
    /**
     * 章节删除状态
     */
    private int sectionDelete;
    /**
     * 课程编号
     */
    private int course_id;
    /**
     * 教师编号
     */
    private int teacherId;
    
    public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
    public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Date getSectionAddTime() {
        return sectionAddTime;
    }

    public void setSectionAddTime(Date sectionAddTime) {
        this.sectionAddTime = sectionAddTime;
    }

    public String getStrSectionAddTime() {
        return strSectionAddTime;
    }

    public void setStrSectionAddTime(String strSectionAddTime) {
        this.strSectionAddTime = strSectionAddTime;
    }

    public String getSeModifyPerson() {
        return seModifyPerson;
    }

    public void setSeModifyPerson(String sectionModifyPerson) {
        this.seModifyPerson = sectionModifyPerson;
    }

    public Date getSectionModifyDate() {
        return sectionModifyDate;
    }
    
    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param sectionModifyDate 数据库取添加日期数据
     */
    public void setSectionModifyDate(Date sectionModifyDate) {
        this.strSeModifyDate=DateUtil.formatDate(sectionModifyDate, "yyyy-HH-dd");
        this.sectionModifyDate = sectionModifyDate;
    }

    public String getStrSeModifyDate() {
        return strSeModifyDate;
    }

    public int getSectionDelete() {
        return sectionDelete;
    }

    public void setSectionDelete(int sectionDelete) {
        this.sectionDelete = sectionDelete;
    }

}
