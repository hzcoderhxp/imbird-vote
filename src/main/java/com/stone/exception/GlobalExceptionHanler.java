package com.stone.exception;

import com.stone.contract.resp.BaseResp;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zzqana on 8/15/2016.
 */
@ControllerAdvice
public class GlobalExceptionHanler {
    private static Logger logger= LoggerFactory.getLogger(GlobalExceptionHanler.class);


    @ExceptionHandler(value = org.springframework.validation.BindException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BaseResp requestParamErrorHandler(HttpServletRequest req, org.springframework.validation.BindException exception) throws Exception {
        loggerException(exception, true);
        if (!exception.getAllErrors().isEmpty() && !StringUtils.isEmpty(exception.getAllErrors().get(0).getDefaultMessage())){
            return BaseResp.create(ResultCode.ERROR_SYSTEM_PARAM_CANNOT_EMPTY).setResultExtend(exception.getAllErrors().get(0).getDefaultMessage());
        }
        return BaseResp.create(ResultCode.ERROR_SYSTEM_PARAM_CANNOT_EMPTY);
    }

    @ExceptionHandler(value = org.mybatis.spring.MyBatisSystemException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BaseResp errorHandler(HttpServletRequest req, org.mybatis.spring.MyBatisSystemException exception) throws Exception {
        loggerException(exception, true);
        return BaseResp.create(ResultCode.ERROR_SYSTEM);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BaseResp errorHandler1(HttpServletRequest req, HttpRequestMethodNotSupportedException exception) throws Exception {
        loggerException(exception, true);
        return BaseResp.create(ResultCode.ERROR_SYSTEM_REQUEST_METHOD_NOT_SUPPORTED);
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BaseResp errorHandler(HttpServletRequest req, NoHandlerFoundException exception) throws Exception {
        loggerException(exception, false);
        return BaseResp.create(ResultCode.ERROR_SYSTEM_REQUEST_IPADDRESS_NOT_FOUND);
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BaseResp errorHandler(HttpServletRequest req, Exception exception) throws Exception {
        loggerException(exception, true);
        return BaseResp.create(ResultCode.ERROR_SYSTEM);
    }


    private void loggerException(Exception ex, boolean isSendEmail){
        logger.error(ex.getMessage());
        StringBuilder traceSB = new StringBuilder();
        for(StackTraceElement elem : ex.getStackTrace()) {
            traceSB.append("at " + elem + "\r\n");
        }
        logger.error(traceSB.toString());
    }
}
