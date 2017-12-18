/**
 * 
 */
package com.education.model;

/**
 * 学费管理多条件查询实体类
 * 
 * @author 周长磊
 *
 */
public class StudentModelDate extends StudentModel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
