package com.education.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import org.springframework.stereotype.Component;
import com.education.util.DateUtil;

/**
 * 课程通知类
 * 
 * @author shenZhongzheng
 *
 */

@Component
public class CourseInform extends CourseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 通知表编号
     */
    private int informId;
    /**
     * 课程时间
     */
    private Date informDate;
    /**
     * 课程时间2 --格式 yyyy-MM-dd
     */
    private String informDateStr;

    /**
     * 通知标题
     */
    private String informInformTitle;
    /**
     * 删除状态
     */
    private int informDelete;

    public int getInformId() {
        return informId;
    }

    public void setInformId(int informId) {
        this.informId = informId;
    }

    public Date getInformDate() {
        return informDate;
    }

    /**
     * @param informDate 
     * 课程时间
     */
    public void setInformDate(Date informDate) {
        this.informDate = informDate;
        this.informDateStr = DateUtil.formatDate(informDate, "yyyy-MM-dd");
    }

    /**
     * @param informDateStr 日期的字符串显示
     * @throws ParseException 抛出异常
     */
    public void setInformDateStr(String informDateStr) throws ParseException {
        this.informDateStr = informDateStr;
        this.informDate = DateUtil.formatString(informDateStr, "yyyy-MM-dd");
    }

    public String getInformDateStr() {
        return informDateStr;
    }

    public String getInformInformTitle() {
        return informInformTitle;
    }

    public void setInformInformTitle(String informInformTitle) {
        this.informInformTitle = informInformTitle;
    }

    public int getInformDelete() {
        return informDelete;
    }

    public void setInformDelete(int informDelete) {
        this.informDelete = informDelete;
    }

    @Override
    public String toString() {
        return "CourseInform [informId=" + informId + ", informDate=" + informDate + ", informDateStr=" + informDateStr
                + ", informInformTitle=" + informInformTitle + ", informDelete=" + informDelete + "]";
    }



}