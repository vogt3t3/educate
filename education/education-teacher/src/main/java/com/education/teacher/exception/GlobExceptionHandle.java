package com.education.teacher.exception;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.education.exception.ServiceException;
import com.education.model.ErrorCode;
import com.education.model.ResultDo;
/**
 * 
 * @author Administrator
 *
 */
@RestControllerAdvice
public class GlobExceptionHandle {
    /**
     * 
     */
    private static Logger LOGGER = LogManager.getLogger(GlobExceptionHandle.class.getName());
    /**
     * @param e 自定义异常
     * @return ErrorCode
     */
    @ExceptionHandler(ServiceException.class)
    public ErrorCode handleException(ServiceException e){
        e.printStackTrace();
        ErrorCode ec=e.getErrorCode();
        e.printStackTrace();
        LOGGER.error(e.getStackTrace());
        return ec;    
    }
    /**
     * @param e 权限控制错误码
     * @return  ResultDo<Object> 返回提示信息
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResultDo<Object> handleException(UnauthorizedException e){
        LOGGER.error(e.getStackTrace());
        ResultDo<Object> rs=new ResultDo<Object>();
        rs.setResMsg("您没有权限访问");
        rs.setResCode(401);
        return rs;
    }
    /**
     * @param e 其他异常处理
     * @return ErrorCode
     */
    @ExceptionHandler(Exception.class)
    public ErrorCode handleException(Exception e){
        e.printStackTrace();
        LOGGER.error(e.getStackTrace());
        ErrorCode ec=ErrorCode.SERVER_ERROR;
        return ec;
    }
   
}
