package com.education.exception;

/**
 * 自定义Shiro异常
 * @author 杨振欣
 *
 */
public class CustomException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 错误信息
     */
    private String message;
    

    public CustomException(String message) {
        super(message);
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
