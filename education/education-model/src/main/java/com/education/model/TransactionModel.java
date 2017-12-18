package com.education.model;

import java.io.Serializable;
import java.util.Date;

import com.education.util.DateUtil;

/**
 * 异动表
 * @author 刘帅
 *
 */
public class TransactionModel implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 异动编号
     */
    private int transactionId;
    
    /**
     * 申请主题
     */
    private String transactionRequest;
    
    /**
     * 申请详细
     */
    private String transactionText;
    
    /**
     * 申请时间
     */
    private Date transactionApplyDate;
    
    /**
     * 申请时间的字符串
     */
    private String transactionApplyDateStr;

    /**
     * 开始时间
     */
    private Date transactionStart;
    
    /**
     * 开始时间的字符串
     */
    private String transactionStartStr;

    /**
     * 申请时长
     */
    private String transactionLong;
    
    /**
     * 现状
     */
    private String transactionCurrState;
    
    /**
     * 审核结果
     */
    private String transactionResState;
    
    /**
     * 删除状态
     */
    private int transactionDelete;
    /**
     * 学生表泛型
     */
    private StudentModel student;
    /**
     * 学生编号
     */
    private int studentId;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 性别
     */
    private String studentSex;
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionRequest() {
        return transactionRequest;
    }

    public void setTransactionRequest(String transactionRequest) {
        this.transactionRequest = transactionRequest;
    }

    public String getTransactionText() {
        return transactionText;
    }

    public void setTransactionText(String transactionText) {
        this.transactionText = transactionText;
    }
    
    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param transactionApplyDate 数据库取添加日期数据
     */
    public void setTransactionApplyDate(Date transactionApplyDate) {
        this.transactionApplyDate = transactionApplyDate;
        this.transactionApplyDateStr = DateUtil.formatDate(transactionApplyDate, "yyyy-MM-dd hh:mm:ss");
    }

    public Date getTransactionApplyDate() {
        return transactionApplyDate;
    }

    public Date getTransactionStart() {
        return transactionStart;
    }

    public String getTransactionApplyDateStr() {
        return transactionApplyDateStr;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param transactionStart 数据库取添加日期数据
     */
    public void setTransactionStart(Date transactionStart) {
        this.transactionStart = transactionStart;
        this.transactionStartStr = DateUtil.formatDate(transactionStart, "yyyy-MM-dd hh:mm:ss");
    }
        
    public String getTransactionStartStr() {
        return transactionStartStr;
    }
   
    public String getTransactionLong() {
        return transactionLong;
    }

    public void setTransactionLong(String transactionLong) {
        this.transactionLong = transactionLong;
    }

    public String getTransactionCurrState() {
        return transactionCurrState;
    }

    public void setTransactionCurrState(String transactionCurrState) {
        this.transactionCurrState = transactionCurrState;
    }

    public String getTransactionResState() {
        return transactionResState;
    }

    public void setTransactionResState(String transactionResState) {
        this.transactionResState = transactionResState;
    }

    public int getTransactionDelete() {
        return transactionDelete;
    }

    public void setTransactionDelete(int transactionDelete) {
        this.transactionDelete = transactionDelete;
    }

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public StudentModel getStudent() {
		return student;
	}

	public void setStudent(StudentModel student) {
		this.student = student;
	}
   
}
