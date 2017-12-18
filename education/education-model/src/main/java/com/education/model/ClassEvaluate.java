package com.education.model;

import java.io.Serializable;
import java.util.Date;
import org.springframework.stereotype.Component;
import com.education.util.DateUtil;

/**
 * 课程评价类
 * 
 * @author shenZhongzheng
 *
 */

@Component
public class ClassEvaluate implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 课程评价编号
     */
    private int classEvaluateId;
    
    /**
     * 课程编号
     */
    private int courseId;
    
    /**
     * 评价内容 [数据库里是Text类型，什么鬼？]
     */
    private String classEvaluateContent;
    /**
     * 提交日期1
     */
    private Date classEvaluateDate;
    /**
     * 提交日期2 --格式 yyyy-MM-dd
     */
    private String classEvaluateDateStr;
    /**
     * 删除状态
     */
    private int classEvaluateDelete;

    public int getClassEvaluateId() {
        return classEvaluateId;
    }

    public void setClassEvaluateId(int classEvaluateId) {
        this.classEvaluateId = classEvaluateId;
    }

    public String getClassEvaluateContent() {
        return classEvaluateContent;
    }

    public void setClassEvaluateContent(String classEvaluateContent) {
        this.classEvaluateContent = classEvaluateContent;
    }

    public Date getClassEvaluateDate() {
        return classEvaluateDate;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string 
     * @param classEvaluateDate 数据库取回复日期数据
     */
    public void setClassEvaluateDate(Date classEvaluateDate) {
        this.classEvaluateDate = classEvaluateDate;
        this.classEvaluateDateStr = DateUtil.formatDate(classEvaluateDate, "yyyy-MM-dd");
    }

    public String getClassEvaluateDateStr() {
        return classEvaluateDateStr;
    }

    public int getClassEvaluateDelete() {
        return classEvaluateDelete;
    }

    public void setClassEvaluateDelete(int classEvaluateDelete) {
        this.classEvaluateDelete = classEvaluateDelete;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
