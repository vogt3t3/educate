package com.education.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import com.education.util.DateUtil;

/**专业表
 * @author Administrator
 *
 */
public class MajorModel implements Serializable{

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
	 * 专业编号
	 */
    private int majorId;
	/**
	 * 专业名称
	 */
    private String majorName;
	/**
	 * 学期
	 */
    private String majorAcademic;
	/**
	 * 专业创建时间
	 */
    private Date majorDate;
    
    /**
     * 专业创建时间(String)
     */
    private String majorDateStr;
	/**
	 * 专业简介
	 */
    private String majorProfile;
	/**
	 * 总学分
	 */
    private int majorCredit;
	/**
	 * 修改人
	 */
    private String majorPerson;
	/**
	 * 修改时间
	 */
    private Date modifyDate;
    /**
     * 修改时间(String)
     */
    private String modifyDateStr;
	/**
	 * 删除状态
	 */
    private int majorDelete;
    public int getMajorId() {
        return majorId;
    }
    public void setMajorId(int majorId) {
        this.majorId = majorId;
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
    public Date getMajorDate() {
        return majorDate;
    }
    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param majorDate 数据库取创建日期数据
     */
    public void setMajorDate(Date majorDate) {
        this.majorDate = majorDate;
        this.majorDateStr = DateUtil.formatDate(majorDate, "yyyy-MM-dd");
    }
    public String getMajorProfile() {
        return majorProfile;
    }
    public void setMajorProfile(String majorProfile) {
        this.majorProfile = majorProfile;
    }
    public int getMajorCredit() {
        return majorCredit;
    }
    public void setMajorCredit(int majorCredit) {
        this.majorCredit = majorCredit;
    }
    public String getMajorPerson() {
        return majorPerson;
    }
    public void setMajorPerson(String majorPerson) {
        this.majorPerson = majorPerson;
    }
    public Date getModifyDate() {
        return modifyDate;
    }
    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param modifyDate 数据库取添加日期数据
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        this.modifyDateStr = DateUtil.formatDate(modifyDate, "yyyy-MM-dd");
    }
    public int getMajorDelete() {
        return majorDelete;
    }
    public void setMajorDelete(int majorDelete) {
        this.majorDelete = majorDelete;
    }
    public String getMajorDateStr() {
        return majorDateStr;
    }
    /**
     * @param majorDateStr 日期的字符串显示
     * @throws ParseException 抛出日期转换异常
     */
    public void setMajorDateStr(String majorDateStr) throws ParseException {
        this.majorDateStr = majorDateStr;
        this.majorDate=DateUtil.formatString(majorDateStr, "yyyy-MM-dd");
    }
    public String getModifyDateStr() {
        return modifyDateStr;
    }
    /**
     * @param modifyDateStr 日期的字符串显示
     * @throws ParseException 抛出日期转换异常
     */
    public void setModifyDateStr(String modifyDateStr) throws ParseException {
        this.modifyDateStr = modifyDateStr;
        this.modifyDate = DateUtil.formatString(modifyDateStr,"yyyy-MM-dd");
    }
    @Override
    public String toString() {
        return "MajorModel [majorId=" + majorId + ", majorName=" + majorName + ", majorAcademic=" + majorAcademic
                + ", majorDate=" + majorDate + ", majorDateStr=" + majorDateStr + ", majorProfile=" + majorProfile
                + ", majorCredit=" + majorCredit + ", majorPerson=" + majorPerson + ", modifyDate=" + modifyDate
                + ", modifyDateStr=" + modifyDateStr + ", majorDelete=" + majorDelete + "]";
    }
}
