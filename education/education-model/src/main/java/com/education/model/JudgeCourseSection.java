package com.education.model;

/**
 * @author 李志鹏
 *
 */
public class JudgeCourseSection extends JudgeTopic{
    
    
    /**
     * 课程编号
     */
    private int courseId;
    
    /**
     * 章节编号
     */
    private int sectionId;
    
    /**
     * 入学测试类型
     */
    private int enterType;
    
    
    
    /**
     * 题库类型
     */
    private int scoreType;
    
    
    /**
     * 题库名称
     */
    private String scoreTypeName;
    
    
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public int getSectionId() {
        return sectionId;
    }
    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }
    public int getEnterType() {
        return enterType;
    }
    public void setEnterType(int enterType) {
        this.enterType = enterType;
    }
    public int getScoreType() {
        return scoreType;
    }
    public void setScoreType(int scoreType) {
        this.scoreType = scoreType;
    }
    public String getScoreTypeName() {
        return scoreTypeName;
    }
    public void setScoreTypeName(String scoreTypeName) {
        this.scoreTypeName = scoreTypeName;
    }
    
}
