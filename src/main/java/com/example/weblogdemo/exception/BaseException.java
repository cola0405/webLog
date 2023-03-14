package com.example.weblogdemo.exception;

import lombok.Data;


/**
 * 自定义一个   异常基类继承运行时异常类
 * *  让其他自定义异常继承
 *
 * @author Xbin
 * @description 业务异常
 * @date 2021-10-13 14:52
 * @email liuhongbindeemail@gmail.com
 */
@Data
public class BaseException extends RuntimeException {

    private int code;

    private String message;

    public BaseException() {
    }

    public BaseException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseException(IResponseEnum responseEnum, Object[] args) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, Throwable cause) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

}
