package com.stone.contract.resp;


import com.stone.exception.ResultCode;

import java.io.Serializable;

/**
 * Created by john on 16-7-6.
 */
public class BaseResp<T> implements Serializable {

    private String code = "0";

    private T result;

    /**
     * 错误类型@see ResultCode
     */
    private Integer errorType ;

    private String errorMsg;

    private boolean isSuccess = true;

    private BaseResp() {
        this.code = ResultCode.NORMAL.getCode();
        this.errorMsg = ResultCode.NORMAL.getMsg();
    }

    private BaseResp(T result) {
        this.code = ResultCode.NORMAL.getCode();
        this.errorMsg = ResultCode.NORMAL.getMsg();
        this.result = result;
    }

    private BaseResp(ResultCode resultCode) {
        if (resultCode == null) {
            this.code = ResultCode.ERROR_SYSTEM.getCode();
            this.errorMsg = ResultCode.ERROR_SYSTEM.getMsg();
        } else {
            this.code = resultCode.getCode();
            this.errorMsg = resultCode.getMsg();
        }
        if (resultCode != null && resultCode.getCode().equals(ResultCode.NORMAL.getCode())) {
            this.isSuccess = true;
        }else {
            this.isSuccess = false;
        }
    }

    private BaseResp(ResultCode resultCode, String msg) {
        this(resultCode);
        this.errorMsg=msg;
    }

    public static BaseResp create(ResultCode resultCode) {
        return new BaseResp(resultCode);
    }


    public static BaseResp create() {
        return new BaseResp();
    }

    public static BaseResp create(Object result) {
        return new BaseResp(result);
    }

    public static BaseResp create(ResultCode resultCode, String msg) {
        return new BaseResp(resultCode,msg);
    }

    public Integer getErrorType() {
        if (errorType == null) {

        }
        return errorType;
    }

    public void setErrorType(Integer errorType) {
        this.errorType = errorType;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setResultCode(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.errorMsg = resultCode.getMsg();
        this.isSuccess = false;
        this.result = null;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public BaseResp setResultExtend(T result) {
        this.result = result;
        return this;
    }

    public BaseResp setErrorMsgExtend(String errorMsg){
        this.errorMsg = errorMsg;
        return this;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

}
