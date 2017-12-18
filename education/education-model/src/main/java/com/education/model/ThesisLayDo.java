package com.education.model;

/**
 * 论文规范扩展类
 * @author 刘帅
 *
 */
public class ThesisLayDo extends ThesisLayoutModel{
    
    /**
     * 专业名称
     */
    private String majorName;
    
    /**
     * 专业编号
     */
    private int majorId;

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }
    
}
