package com.education.model;

public class EnrollStudents extends EnrollStudentsModel{
    /**
     * 招生编号
     */
    private int enroll_id;
    /**
     * 专业编号
     */
    private int majorId;
    
    /**
     * 专业名称
     */
    private String majorName;
    
    
    
    
    public String getMajorName() {
        return majorName;
    }
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
    public int getEnroll_id() {
        return enroll_id;
    }
    public void setEnroll_id(int enroll_id) {
        this.enroll_id = enroll_id;
    }
    public int getMajorId() {
        return majorId;
    }
    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }
 
    
    
    
    

}
