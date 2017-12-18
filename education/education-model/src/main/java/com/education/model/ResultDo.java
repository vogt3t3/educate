package com.education.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 统一返回json格式
 * 
 * @author Administrator
 * @param <T>
 *
 */
@Component
public class ResultDo<T> implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 业务码
     */
    private int resCode;
    /**
     * 业务消息
     */
    private String resMsg;
    /**
     * 业务数据
     */
    private T resData;
    
    /**
     * 课程
     */
    private String kecheng;
    
    public String getKecheng() {
        return kecheng;
    }

    public void setKecheng(String kecheng) {
        this.kecheng = kecheng;
    }

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public T getResData() {
        return resData;
    }

    public void setResData(T resData) {
        this.resData = resData;
    }

}
