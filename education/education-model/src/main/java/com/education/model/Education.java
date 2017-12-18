package com.education.model;

import java.io.Serializable;
import java.util.Date;
import org.springframework.stereotype.Component;
import com.education.util.DateUtil;

/**
 * 教学计划类.
 * 
 * @author 徐鹏超
 *
 */
@Component
public class Education implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 教学计划编号
     */
    private int educationPlanId;
    /**
	 * 专业编号
	 */
    private int majorId;
    /**
     * 年级
     */
    private String educationGrade;
    /**
     * 创建时间1
    */
    private Date eduCreateDate;
    /**
     * 创建时间2 --格式 yyyy-MM-dd
     */
    private String eduCreateDateStr;
    /**
     * 修改人
     */
    private String eduPlanModifyPer;
    /**
     * 修改时间1
     */
    private Date eduPlanModDate;
    /**
     * 修改时间2 --格式 yyyy-MM-dd
    */
    private String eduPlanModDateStr;
    
    /**
     * 刪除状态
     */ 
    private int eduPlanDelete;
    
    /**
     * 课程名称
     */
    private String courseName;
    
    /**
     * 课程类别
     */
    private String courseClass;
    
    /**
	 * 专业名称
	 */
    private String majorName;
	/**
	 * 学期
	 */
    private String majorAcademic;
    
    /**
	 * 总学分
	 */
    private int majorCredit;

    public int getEducationPlanId() {
        return educationPlanId;
    }

    public void setEducationPlanId(int educationPlanId) {
        this.educationPlanId = educationPlanId;
    }

    public String getEducationGrade() {
        return educationGrade;
    }

    public void setEducationGrade(String educationGrade) {
        this.educationGrade = educationGrade;
    }

    public Date getEduCreateDate() {
        return eduCreateDate;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string 
     * @param eduCreateDate 数据库取回复日期数据
     */
    public void setEduCreateDate(Date eduCreateDate) {
        this.eduCreateDate = eduCreateDate;
        this.eduCreateDateStr = DateUtil.formatDate(eduCreateDate, "yyyy-MM-dd");
    }

    public String getEduCreateDateStr() {
        return eduCreateDateStr;
    }

 

    public String getEduPlanModifyPer() {
        return eduPlanModifyPer;
    }

    public void setEduPlanModifyPer(String eduPlanModifyPer) {
        this.eduPlanModifyPer = eduPlanModifyPer;
    }

    public Date getEduPlanModDate() {
        return eduPlanModDate;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string 
     * @param eduPlanModDate 数据库取回复日期数据
     */
    public void setEduPlanModDate(Date eduPlanModDate) {
        this.eduPlanModDate = eduPlanModDate;
        this.eduPlanModDateStr = DateUtil.formatDate(eduPlanModDate, "yyyy-MM-dd");

    }

    public String getEduPlanModDateStr() {
        return eduPlanModDateStr;
    }

   

    public int getEduPlanDelete() {
        return eduPlanDelete;
    }

    public void setEduPlanDelete(int eduPlanDelete) {
        this.eduPlanDelete = eduPlanDelete;
    }

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseClass() {
		return courseClass;
	}

	public void setCourseClass(String courseClass) {
		this.courseClass = courseClass;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getMajorAcademic() {
		return majorAcademic;
	}

	public void setMajorAcademic(String majorAcademic) {
		this.majorAcademic = majorAcademic;
	}

	public int getMajorCredit() {
		return majorCredit;
	}

	public void setMajorCredit(int majorCredit) {
		this.majorCredit = majorCredit;
	}

    
}
