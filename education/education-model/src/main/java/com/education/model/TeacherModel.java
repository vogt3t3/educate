package com.education.model;

import java.io.Serializable;
import java.util.Date;
import com.education.util.DateUtil;

/**
 * 教师信息实体类
 * 
 * @author ZHANGHENG
 *
 */
public class TeacherModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {

        return "TeacherModel [teacherId=" + teacherId + ", teacherPwd=" + teacherPwd + ", teacherRealName="
                + teacherRealName + ", teacherBirth=" + teacherBirth + ", teacherBirthStr=" + teacherBirthStr
                + ", teacherSex=" + teacherSex + ", teacherPolitical=" + teacherPolitical + ", teacherNational="
                + teacherNational + ", teacherRecord=" + teacherRecord + ", teacherNative=" + teacherNative
                + ", teacherSchool=" + teacherSchool + ", teacherDegree=" + teacherDegree + ", teacherEmail="
                + teacherEmail + ", teacherPhone=" + teacherPhone + ", teacherAdderss=" + teacherAdderss
                + ", teacherCategory=" + teacherCategory + ", teacherTranning=" + teacherTranning + ", teacherReward="
                + teacherReward + ", teacherPunish=" + teacherPunish + ", teacherDetail=" + teacherDetail
                + ", teacherPhoto=" + teacherPhoto + ", teacherCreateDate=" + teacherCreateDate
                + ", teacherCreateDateStr=" + teacherCreateDateStr + ", teacherLastLoginDate=" + teacherLastLoginDate
                + ", teacherLastLoginDateStr=" + teacherLastLoginDateStr + ", teacherSuntime=" + teacherSuntime
                + ", teacherModifyPerson=" + teacherModifyPerson + ", teacherModifyDate=" + teacherModifyDate
                + ", teacherModifyDateStr=" + teacherModifyDateStr + ", teacherDelete=" + teacherDelete + "]";
    }

    /**
     * 教师编号
     */
    private int teacherId;
    /**
     * 学生编号
     */
    private int studentId;
    // 要引入课程表课程编号
    /**
     * 登录密码
     */
    private String teacherPwd;
    /**
     * 课程
     */
    private CourseModel courseModel;
    /**
     * 真实姓名
     */
    private String teacherRealName;
    /**
     * 生日
     */
    private Date teacherBirth;
    /**
     * 生日的字符串显示
     */
    private String teacherBirthStr;
    /**
     * 性别
     */
    private String teacherSex;
    /**
     * 政治面貌
     */
    private String teacherPolitical;
    /**
     * 民族
     */
    private String teacherNational;
    /**
     * 最高学历
     */
    private String teacherRecord;
    /**
     * 籍贯
     */
    private String teacherNative;
    /**
     * 毕业学院
     */
    private String teacherSchool;
    /**
     * 最高学位
     */
    private String teacherDegree;
    /**
     * 邮箱
     */
    private String teacherEmail;
    /**
     * 联系电话
     */
    private String teacherPhone;
    /**
     * 地址
     */
    private String teacherAdderss;
    /**
     * 教室角色
     */
    private String teacherRole;
    /**
     * 教师类别
     */
    private String teacherCategory;
    /**
     * 进修情况
     */
    private String teacherTranning;
    /**
     * 曾获奖励
     */
    private String teacherReward;
    /**
     * 曾获处分
     */
    private String teacherPunish;
    /**
     * 个人简介
     */
    private String teacherDetail;
    /**
     * 照片
     */
    private String teacherPhoto;
    /**
     * 创建时间
     */
    private Date teacherCreateDate;
    /**
     * 创建时间字符串显示
     */
    private String teacherCreateDateStr;
    /**
     * 上次登录时间
     */
    private Date teacherLastLoginDate;
    /**
     * 上次登录时间字符串显示
     */
    private String teacherLastLoginDateStr;
    /**
     * 登录时长
     */
    private int teacherSuntime;

    /**
     * 修改人
     */
    private String teacherModifyPerson;
    /**
     * 修改时间
     */

    private Date teacherModifyDate;
    /**
     * 修改时间字符串显示
     */
    private String teacherModifyDateStr;

    /**
     * 删除状态
     */
    private String teacherDelete;
    
    /**
     * 课程id
     */
    private int courseId;
    /**
     * 课程名称 
     */
    private String courseName;
    /**
     * 角色id
     */
    private int roleId;
    /**
     * 角色说明
     */
    private String roleDesc;
    
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getTeacherPwd() {
        return teacherPwd;
    }

    public void setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd;
    }

    public String getTeacherRealName() {
        return teacherRealName;
    }

    public void setTeacherRealName(String teacherRealName) {
        this.teacherRealName = teacherRealName;
    }

    public Date getTeacherBirth() {
        return teacherBirth;
    }

    /**
     * 
     * @param teacherBirth
     *            Data类型的教师生日
     */
    public void setTeacherBirth(Date teacherBirth) {

        this.teacherBirthStr = DateUtil.formatDate(teacherBirth, "yyyy-MM-dd");

        this.teacherBirth = teacherBirth;
    }

    public String getTeacherBirthStr() {
        return teacherBirthStr;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherPolitical() {
        return teacherPolitical;
    }

    public void setTeacherPolitical(String teacherPolitical) {
        this.teacherPolitical = teacherPolitical;
    }

    public String getTeacherNational() {
        return teacherNational;
    }

    public void setTeacherNational(String teacherNational) {
        this.teacherNational = teacherNational;
    }

    public String getTeacherRecord() {
        return teacherRecord;
    }

    public void setTeacherRecord(String teacherRecord) {
        this.teacherRecord = teacherRecord;
    }

    public String getTeacherNative() {
        return teacherNative;
    }

    public void setTeacherNative(String teacherNative) {
        this.teacherNative = teacherNative;
    }

    public String getTeacherSchool() {
        return teacherSchool;
    }

    public void setTeacherSchool(String teacherSchool) {
        this.teacherSchool = teacherSchool;
    }

    public String getTeacherDegree() {
        return teacherDegree;
    }

    public void setTeacherDegree(String teacherDegree) {
        this.teacherDegree = teacherDegree;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public String getTeacherAdderss() {
        return teacherAdderss;
    }

    public void setTeacherAdderss(String teacherAdderss) {
        this.teacherAdderss = teacherAdderss;

    }

    public String getTeacherRole() {
        return teacherRole;
    }

    public void setTeacherRole(String teacherRole) {
        this.teacherRole = teacherRole;

    }

    public String getTeacherCategory() {
        return teacherCategory;
    }

    public void setTeacherCategory(String teacherCategory) {
        this.teacherCategory = teacherCategory;
    }

    public String getTeacherTranning() {
        return teacherTranning;
    }

    public void setTeacherTranning(String teacherTranning) {
        this.teacherTranning = teacherTranning;
    }

    public String getTeacherReward() {
        return teacherReward;
    }

    public void setTeacherReward(String teacherReward) {
        this.teacherReward = teacherReward;
    }

    public String getTeacherPunish() {
        return teacherPunish;
    }

    public void setTeacherPunish(String teacherPunish) {
        this.teacherPunish = teacherPunish;
    }

    public String getTeacherDetail() {
        return teacherDetail;
    }

    public void setTeacherDetail(String teacherDetail) {
        this.teacherDetail = teacherDetail;
    }

    public String getTeacherPhoto() {
        return teacherPhoto;
    }

    public void setTeacherPhoto(String teacherPhoto) {
        this.teacherPhoto = teacherPhoto;
    }

    public int getTeacherSuntime() {
        return teacherSuntime;
    }

    public void setTeacherSuntime(int teacherSuntime) {
        this.teacherSuntime = teacherSuntime;
    }

    public String getTeacherModifyPerson() {
        return teacherModifyPerson;

    }

    public void setTeacherModifyPerson(String teacherModifyPerson) {
        this.teacherModifyPerson = teacherModifyPerson;

    }

    public String getTeacherDelete() {
        return teacherDelete;
    }

    public void setTeacherDelete(String teacherDelete) {
        this.teacherDelete = teacherDelete;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public Date getTeacherCreateDate() {
        return teacherCreateDate;
    }

    /**
     * @param teacherCreateDate
     *            Date类型的教师账号创建时间
     */
    public void setTeacherCreateDate(Date teacherCreateDate) {

        this.teacherCreateDateStr = DateUtil.formatDate(teacherCreateDate, "yyyy-MM-dd hh:mm:ss");

        this.teacherCreateDate = teacherCreateDate;
    }

    public String getTeacherCreateDateStr() {
        return teacherCreateDateStr;
    }

    public Date getTeacherLastLoginDate() {
        return teacherLastLoginDate;
    }

    /**
     * @param teacherLastLoginDate
     *            教师上次登录时间
     */
    public void setTeacherLastLoginDate(Date teacherLastLoginDate) {

        this.teacherLastLoginDateStr = DateUtil.formatDate(teacherLastLoginDate, "yyyy-MM-dd hh:mm:ss");

        this.teacherLastLoginDate = teacherLastLoginDate;
    }

    public String getTeacherLastLoginDateStr() {

        return teacherLastLoginDateStr;

    }

    public Date getTeacherModifyDate() {
        return teacherModifyDate;
    }

    /**
     * @param teacherModifyDate
     *            教师信息上次修改时间
     */
    public void setTeacherModifyDate(Date teacherModifyDate) {

        this.teacherModifyDateStr = DateUtil.formatDate(teacherModifyDate, "yyyy-MM-dd hh:mm:ss");

        this.teacherModifyDate = teacherModifyDate;
    }

    public String getTeacherModifyDateStr() {
        return teacherModifyDateStr;

    }

    public CourseModel getCourseModel() {
        return courseModel;
    }

    public void setCourseModel(CourseModel courseModel) {
        this.courseModel = courseModel;
    }

}
