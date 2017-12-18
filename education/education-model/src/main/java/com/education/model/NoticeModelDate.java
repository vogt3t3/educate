package com.education.model;

/**
 * 公告管理日期查询实体
 * 
 * @author 张建磊
 *
 */
public class NoticeModelDate extends NoticeModel {

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
