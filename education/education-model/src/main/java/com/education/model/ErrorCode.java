package com.education.model;

import java.io.Serializable;

/**
 * 错误类型代码
 * @author Administrator
 *
 */
public enum ErrorCode implements Serializable{
    /**
     * 枚举类型常量
     *
     */
    SYS_ERROR(1, "系统错误！"), SERVER_ERROR(2, "服务器错误！!");
    /**
     * 错误代码
     */
    private int errorNum;
    
    /**
     * 错误信息提示
     */
    private String errorMsg;

    ErrorCode(int num, String msg) {
        this.errorNum = num;
        this.errorMsg = msg;
    }

    public int getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(int errorNum) {
        this.errorNum = errorNum;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
