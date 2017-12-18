package com.education.model;
import java.io.Serializable;
import java.util.Date;
import com.education.util.DateUtil;

/**
 * 学生报名模型
 * 
 * @author ZHAORUN
 *
 */
public class StudentEnterModel implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 报名编号
     */
    private int enterId;    
    
    /**
     * 姓名
     */
    private String enterName;
    /**
     * 性别
     */
    private String enterSex;
    /**
     * 出生日期
     */
    private Date enterBirth;
    /**
     * 出生日期的字符串
     */
    private String strEnterBirth;
    /**
     * 民族
     */
    private String enterNation;
    /**
     * 身份证
     */
    private String enterIdCard;
    /**
     * 手机号
     */
    private String enterPhone;
    /**
     * 毕业院校
     */
    private String enterGraduate;
    /**
     * 地址
     */
    private String enterAddress;
    /**
     * 学历
     */
    private String enterEducation;
    /**
     * 照片
     */
    private String enterPhoto;
    /**
     * email
     */
    private String enterEmail;
    /**
     * 审核状态
     */
    private int enterCheckState;
    /**
     * 审核时间 Date
     */
    private Date enterCheckDate;
    /**
     * 审核时间 String
     */
    private String strEnterCheckDate;
    /**
     * 初考成绩
     */
    private int enterFirstScore;
    /**
     * 初考及格或不及格
     */
    private String enterFirstStringScore;
    /**
     * 报名日期 Date
     */
    private Date enterDate;
    /**
     * 报名日期 String
     */
    private String strEnterDate;
    /**
     * 所选形式
     */
    private int enterType;
    /**
     * 缴费状态
     */
    private int enterPayState;
    /**
     * 缴费方式
     */
    private int enterPayWay;
    /**
     * 缴费金额
     */
    private double enterPayMoney;
    /**
     * 缴费日期 Date
     */
    private Date enterPayDate;
    /**
     * 缴费日期 String
     */
    private String strEnterPayDate;
    /**
     * 报名状态
     */
    private int enterDelete;
    /**
     * 专业Id
     */
    public int majorId;
    /**
     * 专业名称
     */
    public String majorName;
    /**
     * 毕业证件照
     */
    private String enterCertificate;
    
    
    /**
     * 下面五个字段是重点，请勿删除，删除会造成部分系统崩溃
     * 1.所选专业应交学费
     */
    private String enrollTuition;
    /**
     * 2.审核状态
     */
	private String enterCheckStringState;
	/**
     * 3.所选类型
     */
	private String enterStringType;
     /**
     * 4.缴费状态
     */
	private String enterPayStringState;
    /**
    * 5.缴费方式
    */
	private String enterPayStringWay;
	
	private String majorMame;

	public String getMajorMame() {
		return majorMame;
	}
	public void setMajorMame(String majorMame) {
		this.majorMame = majorMame;
	}
	/**
     * 审核状态
     */
    public String getEnterCheckStringState() {
		return enterCheckStringState;
	}
	/**
     * 所选类型
     */
	public String getEnterStringType() {
		return enterStringType;
	}
	/**
     * 缴费状态
     */
	public String getEnterPayStringState() {
		return enterPayStringState;
	}
	/**
     * 缴费方式
     */
	public String getEnterPayStringWay() {
		return enterPayStringWay;
	}
	/**
     * 缴费方式
     */
	@SuppressWarnings("unused")
	private void setEnterPayStringWay(int enterPayWay) {
		this.enterPayWay = enterPayWay;
		if(enterPayWay==1){
			this.enterPayStringWay = "微信";
		}else if(enterPayWay==2){
			this.enterPayStringWay = "支付宝";
		}else if(enterPayWay==3){
			this.enterPayStringWay = "银行卡";
		}
		this.enterPayStringWay = "未选择支付方式";
	}
	

	public int getEnterId() {
        return enterId;
    }

    public void setEnterId(int enterId) {
        this.enterId = enterId;
    }

    public String getEnterName() {
        return enterName;
    }

    public void setEnterName(String enterName) {
        this.enterName = enterName;
    }

    public String getEnterSex() {
        return enterSex;
    }

    public void setEnterSex(String enterSex) {
        this.enterSex = enterSex;
        
    }

    public Date getEnterBirth() {
        return enterBirth;
        
    }
    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param enterBirth 数据库取添加日期数据
     */
    public void setEnterBirth(Date enterBirth) {
        this.enterBirth = enterBirth;
        this.strEnterBirth = DateUtil.formatDate(enterBirth, "yyyy-MM-dd");
    }

    public String getStrEnterBirth() {
        return strEnterBirth;
    }

    public String getEnterNation() {
        return enterNation;
    }

    public void setEnterNation(String enterNation) {
        this.enterNation = enterNation;
    }

    public String getEnterIdCard() {
        return enterIdCard;
    }

    public void setEnterIdCard(String enterIdCard) {
        this.enterIdCard = enterIdCard;
    }

    public String getEnterPhone() {
        return enterPhone;
    }

    public void setEnterPhone(String enterPhone) {
        this.enterPhone = enterPhone;
    }

    public String getEnterGraduate() {
        return enterGraduate;
    }

    public void setEnterGraduate(String enterGraduate) {
        this.enterGraduate = enterGraduate;
    }

    public String getEnterAddress() {
        return enterAddress;
    }

    public void setEnterAddress(String enterAddress) {
        this.enterAddress = enterAddress;
    }

    public String getEnterEducation() {
        return enterEducation;
    }

    public void setEnterEducation(String enterEducation) {
        this.enterEducation = enterEducation;
    }

    public String getEnterPhoto() {
        return enterPhoto;
    }

    public void setEnterPhoto(String enterPhoto) {
        this.enterPhoto = enterPhoto;
    }

    public String getEnterEmail() {
        return enterEmail;
    }

    public void setEnterEmail(String enterEmail) {
        this.enterEmail = enterEmail;
    }

    public int getEnterCheckState() {
        return enterCheckState;
    }

    public void setEnterCheckState(int enterCheckState) {
        this.enterCheckState = enterCheckState;
		if(enterCheckState==1){
			this.enterCheckStringState = "审核通过";
		}
		this.enterCheckStringState = "审核未通过";
    }

    public Date getEnterCheckDate() {
        return enterCheckDate;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param enterCheckDate 数据库取添加日期数据
     */
    public void setEnterCheckDate(Date enterCheckDate) {
        this.enterCheckDate = enterCheckDate;
        this.strEnterCheckDate = DateUtil.formatDate(enterCheckDate, "yyyy-MM-dd");
    }

    public String getStrEnterCheckDate() {
        return strEnterCheckDate;
    }

    public int getEnterFirstScore() {
        return enterFirstScore;
    }

    public void setEnterFirstScore(int enterFirstScore) {
        this.enterFirstScore = enterFirstScore;
        if(enterFirstScore>=60){
			this.enterFirstStringScore = "考试成绩通过";
		}
		this.enterFirstStringScore = "考试成绩未通过";
    }
    
    /**
     * 初考及格或不及格String
     */
    public String getEnterFirstStringScore() {
        return enterFirstStringScore;
    }

    public Date getEnterDate() {
        return enterDate;
    }
    
    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param enterDate 数据库取添加日期数据
     */
    public void setEnterDate(Date enterDate) {
        this.strEnterDate=DateUtil.formatDate(enterDate, "yyyy-MM-dd");
        this.enterDate = enterDate;
    }

    public String getStrEnterDate() {
        return strEnterDate;
    }

    public int getEnterType() {
        return enterType;
    }

    public void setEnterType(int enterType) {
        this.enterType = enterType;
		if(enterType==1){
			this.enterStringType = "高升专";
		}else if(enterType==2){
			this.enterStringType = "专升本";
		}else if(enterType==3){
			this.enterStringType = "高升本";
		}
		this.enterStringType = "未选";
    }

    public int getEnterPayState() {
        return enterPayState;
    }

    public void setEnterPayState(int enterPayState) {
        this.enterPayState = enterPayState;
		if(enterPayState==1){
			this.enterPayStringState = "已缴费";
		}
		this.enterPayStringState = "未缴费";
    }

    public int getEnterPayWay() {
        return enterPayWay;
    }

    public void setEnterPayWay(int enterPayWay) {
        this.enterPayWay = enterPayWay;
		if(enterPayWay==1){
			this.enterPayStringWay = "微信";
		}else if(enterPayWay==2){
			this.enterPayStringWay = "支付宝";
		}else if(enterPayWay==3){
			this.enterPayStringWay = "银行卡";
		}
		this.enterPayStringWay = "未选择支付方式";
    }

    public double getEnterPayMoney() {
        return enterPayMoney;
    }

    public void setEnterPayMoney(double enterPayMoney) {
        this.enterPayMoney = enterPayMoney;
    }

    public Date getEnterPayDate() {
        return enterPayDate;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param enterPayDate 数据库取添加日期数据
     */
    public void setEnterPayDate(Date enterPayDate) {
        this.strEnterPayDate=DateUtil.formatDate(enterPayDate, "yyyy-MM-dd");
        this.enterPayDate = enterPayDate;
    }

    public String getStrEnterPayDate() {
        return strEnterPayDate;
    }

    public int getEnterDelete() {
        return enterDelete;
    }

    public void setEnterDelete(int enterDelete) {
        this.enterDelete = enterDelete;
    }

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getEnterCertificate() {
		return enterCertificate;
	}
	public void setEnterCertificate(String enterCertificate) {
		this.enterCertificate = enterCertificate;
	}
	public String getEnrollTuition() {
		return enrollTuition;
	}
	public void setEnrollTuition(String enrollTuition) {
		this.enrollTuition = enrollTuition;
	}
	
	
}
