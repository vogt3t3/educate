/**
 * 
 */
package com.education.model;
import java.io.Serializable;
import java.util.Date;
import com.education.util.DateUtil;

/**
 * 学生表
 * 
 * @author 周长磊
 *
 */
public class StudentModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 学生编号
	 */
	private int studentId;
	/**
	 * 专业编号
	 */
	private int majorId;
	
	/**
	 * 招生编号
	 */
	private int enrollId;
	
	/**
	 * 费用
	 */
	private double enrollTuition;

	/**
	 * 专业名称
	 */
	private String majorName;
	
	
	
	/**
	 * 论文表编号
	 */
	private int thesisId;

	/**
	 * 密码
	 */
	private String studentPassword;
	/**
	 * 学生姓名
	 */
	private String studentName;
	/**
	 * 性别
	 */
	private String studentSex;
	/**
	 * 民族
	 */
	private String studentNation;
	/**
	 * 身份证号
	 */
	private String studentIdcard;
	/**
	 * 手机号
	 */
	private String studentPhone;
	/**
	 * 毕业院校
	 */
	private String studentGraduate;
	/**
	 * 出生日期
	 */
	private Date stuBirth;

	/**
	 * 出生日期的字符串
	 */
	private String stuBirthStr;

	/**
	 * 家庭住址
	 */
	private String stuAddress;
	/**
	 * 学历
	 */
	private String stuEducation;
	/**
	 * 毕业证照片
	 */
	private String certificate;
	/**
	 * 二寸照片
	 */
	private String studentPhoto;
	/**
	 * 邮箱
	 */
	private String studentEmail;
	/**
	 * 报名日期
	 */
	private Date studentDate;

	/**
	 * 报名日期字符串
	 */
	private String studentDateStr;

	/**
	 * 所选类型（升学类型）
	 */
	private String studentType;
	/**
	 * 缴费方式
	 */
	private int studentPayWay;
	

	/**
	 * 第一次缴费
	 */
	private double firstMoney;
	/**
	 * 第一次缴费时间
	 */
	private Date firstMoneyTime;

	/**
	 * 第一次缴费状态
	 */
	private String firstMoneyState;

	/**
	 * 第一次缴费时间字符串
	 */
	private String firstMoneyTimeStr;

	/**
	 * 第二次缴费
	 */
	private double secondMoney;
	/**
	 * 第二次缴费时间
	 */
	private Date secondMoneyTime;

	/**
	 * 第二次缴费时间字符串
	 */
	private String seMoneyTimeStr;

	/**
	 * 第二次缴费状态
	 */
	private String secondMoneyState;

	/**
	 * 修改人
	 */
	private String modifyPerson;
	/**
	 * 修改时间
	 */
	private Date modifyDate;

	/**
//	 * 修改时间字符串
	 */
	private String modifyDateStr;

	/**
	 * 最后在线时间
	 */
	private Date studentLastTime;

	/**
	 * 最后在线时间字符串
	 */
	private String stuLastTimeStr;

	/**
	 * 总计在线时长
	 */
	private String studentTotalTime;
	/**
	 * 是否毕业
	 */
	private String studentGraduation;

	/**
	 * 删除状态
	 */
	private int studentDelete;
	
	/**
	 *备注
	 */
	private String studentRemark;

	public String getStudentRemark() {
		return studentRemark;
	}

	public void setStudentRemark(String studentRemark) {
		this.studentRemark = studentRemark;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getMajorId() {

		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public int getThesisId() {
		return thesisId;
	}

	public void setThesisId(int thesisId) {
		this.thesisId = thesisId;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public String getStudentNation() {
		return studentNation;
	}

	public void setStudentNation(String studentNation) {
		this.studentNation = studentNation;
	}

	public String getStudentIdcard() {
		return studentIdcard;
	}

	public void setStudentIdcard(String studentIdcard) {
		this.studentIdcard = studentIdcard;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getStudentGraduate() {
		return studentGraduate;
	}

	public void setStudentGraduate(String studentGraduate) {
		this.studentGraduate = studentGraduate;
	}

	/**
	 * 数据库传输用Date 前台取date用string
	 * 
	 * @param stuBirth
	 *            数据库取添加日期数据
	 */
	public void setStuBirth(Date stuBirth) {
		this.stuBirth = stuBirth;
		this.stuBirthStr = DateUtil.formatDate(stuBirth, "yyyy-MM-dd hh:mm:ss");
	}

	public Date getFirstMoneyTime() {
		return firstMoneyTime;
	}

	public Date getSecondMoneyTime() {
		return secondMoneyTime;
	}

	public String getStuBirthStr() {
		return stuBirthStr;
	}

	public String getStuAddress() {
		return stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public String getStuEducation() {
		return stuEducation;
	}

	public void setStuEducation(String stuEducation) {
		this.stuEducation = stuEducation;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getStudentPhoto() {
		return studentPhoto;
	}

	public void setStudentPhoto(String studentPhoto) {
		this.studentPhoto = studentPhoto;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	/**
	 * 数据库传输用Date 前台取date用string
	 * 
	 * @param studentDate
	 *            数据库取添加日期数据
	 */
	public void setStudentDate(Date studentDate) {
		this.studentDate = studentDate;
		this.studentDateStr = DateUtil.formatDate(studentDate, "yyyy-MM-dd");
	}

	public String getStudentDateStr() {
		return studentDateStr;
	}

	public String getStudentType() {

		return studentType;
	}

	public void setStudentType(String studentType) {

		this.studentType = studentType;
	}



	public int getStudentPayWay() {
		return studentPayWay;
	}

	public void setStudentPayWay(int studentPayWay) {
		this.studentPayWay = studentPayWay;
	}

	public double getFirstMoney() {
		return firstMoney;
	}

	public void setFirstMoney(double firstMoney) {
		this.firstMoney = firstMoney;
	}

	/**
	 * 数据库传输用Date 前台取date用string
	 * 
	 * @param firstMoneyTime
	 *            数据库取添加日期数据
	 */
	public void setFirstMoneyTime(Date firstMoneyTime) {
		this.firstMoneyTime = firstMoneyTime;
		this.firstMoneyTimeStr = DateUtil.formatDate(firstMoneyTime, "yyyy-MM-dd ");
	}

	public String getFirstMoneyTimeStr() {
		return firstMoneyTimeStr;
	}

	public double getSecondMoney() {
		return secondMoney;
	}

	public void setSecondMoney(double secondMoney) {
		this.secondMoney = secondMoney;
	}

	/**
	 * 数据库传输用Date 前台取date用string
	 * 
	 * @param secondMoneyTime
	 *            数据库取添加日期数据
	 */
	public void setSecondMoneyTime(Date secondMoneyTime) {
		this.secondMoneyTime = secondMoneyTime;
		this.seMoneyTimeStr = DateUtil.formatDate(secondMoneyTime, "yyyy-MM-dd");
	}

	public String getSeMoneyTimeStr() {
		return seMoneyTimeStr;
	}

	public String getModifyPerson() {
		return modifyPerson;
	}

	public void setModifyPerson(String modifyPerson) {
		this.modifyPerson = modifyPerson;
	}

	/**
	 * 数据库传输用Date 前台取date用string
	 * 
	 * @param modifyDate
	 *            数据库取添加日期数据
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
		this.modifyDateStr = DateUtil.formatDate(modifyDate, "yyyy-MM-dd HH:mm:ss");
	}

	public String getModifyDateStr() {
		return modifyDateStr;
	}

	/**
	 * 数据库传输用Date 前台取date用string
	 * 
	 * @param studentLastTime
	 *            数据库取添加日期数据
	 */
	public void setStudentLastTime(Date studentLastTime) {
		this.studentLastTime = studentLastTime;
		this.stuLastTimeStr = DateUtil.formatDate(studentLastTime, "yyyy-MM-dd HH:mm:ss");
	}

	public String getStuLastTimeStr() {
		return stuLastTimeStr;
	}

	public String getStudentTotalTime() {
		return studentTotalTime;
	}

	public void setStudentTotalTime(String studentTotalTime) {
		this.studentTotalTime = studentTotalTime;
	}

	public String getStudentGraduation() {
		return studentGraduation;
	}

	public void setStudentGraduation(String studentGraduation) {
		this.studentGraduation = studentGraduation;
	}

	public Date getStuBirth() {
		return stuBirth;
	}

	public Date getStudentDate() {
		return studentDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public Date getStudentLastTime() {
		return studentLastTime;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getFirstMoneyState() {
		return firstMoneyState;
	}

	public void setFirstMoneyState(String firstMoneyState) {
		this.firstMoneyState = firstMoneyState;
	}

	public String getSecondMoneyState() {
		return secondMoneyState;
	}

	public void setSecondMoneyState(String secondMoneyState) {
		this.secondMoneyState = secondMoneyState;
	}

	
	public double getEnrollTuition() {
		return enrollTuition;
	}

	public void setEnrollTuition(double enrollTuition) {
		this.enrollTuition = enrollTuition;
	}


}
