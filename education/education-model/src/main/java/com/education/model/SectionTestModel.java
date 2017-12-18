package com.education.model;

import java.io.Serializable;

/**
 * 章节测试实体类
 * @author FYM
 *
 */
public class SectionTestModel implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 章节测试编号
     */
    private int secTestId;
    /**
     * 可测试状态
     */
    private int secTestState;
    /**
     * 章节分数
     */
    private int secTestScore;
    /**
     * 删除状态
     */
    private int secTestDel;
    public int getSecTestId() {
        return secTestId;
    }
    public void setSecTestId(int secTestId) {
        this.secTestId = secTestId;
    }
    public int getSecTestState() {
        return secTestState;
    }
    public void setSecTestState(int secTestState) {
        this.secTestState = secTestState;
    }
    public int getSecTestScore() {
        return secTestScore;
    }
    public void setSecTestScore(int secTestScore) {
        this.secTestScore = secTestScore;
    }
    public int getSecTestDel() {
        return secTestDel;
    }
    public void setSecTestDel(int secTestDel) {
        this.secTestDel = secTestDel;
    }
    
}
