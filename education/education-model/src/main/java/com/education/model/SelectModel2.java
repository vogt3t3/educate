package com.education.model;

import java.io.Serializable;
import java.util.Date;

import com.education.util.DateUtil;

/**
 * 选择题表_试卷——扩展类
 * @author 申忠正
 *
 */
public class SelectModel2 extends SelectModel implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
   
    /**
     * 题库类型
     * (1为期末考试，2为章节测试，3为入学测试 
     */
    private int score_type;
    /**
     * 课程编号
     */
    private int course_id;
    public int getScore_type() {
        return score_type;
    }
    public void setScore_type(int score_type) {
        this.score_type = score_type;
    }
    public int getCourse_id() {
        return course_id;
    }
    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
    
}
