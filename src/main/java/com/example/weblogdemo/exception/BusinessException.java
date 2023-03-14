package com.example.weblogdemo.exception;


/**
* @author Xbin
* @description 业务异常
* @date 2021-10-13 14:52
* @email liuhongbindeemail@gmail.com
*/

public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException(int code ,String message) {
        super(code,message);
    }

    public BusinessException(IResponseEnum responseEnum, Object[] args) {
        super(responseEnum, args);
    }

    public BusinessException(IResponseEnum responseEnum, Object[] args, Throwable cause) {
        super(responseEnum, args, cause);
    }
}
