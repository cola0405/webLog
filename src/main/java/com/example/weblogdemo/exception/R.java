package com.example.weblogdemo.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author Xbin
* @description 封装客户端返回的数据 不返回数据
* @date 2021-10-14 13:36
* @email liuhongbindeemail@gmail.com
*/
@Data
@NoArgsConstructor
public class R {

    private static final long serialVersionUID = 1L;

    /**
     * 响应码
     */
    private Integer ret;
    /**
     * 响应信息
     */
    private String message;


    public R(CodeEnum codeEnum) {
        this.ret = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public R(Integer ret, String message) {
        this.ret = ret;
        this.message = message;
    }

    /**
     * 使用CodeEnum模板中定义好的
     * @param codeEnum
     * @return
     */
    public static R codeEnum(CodeEnum codeEnum) {
        return new R().setCodeEnum(codeEnum);
    }

    /**
     * 返回200
     *
     * @return
     */
    public static R success() {
        return new R(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMessage());
    }

    public static R success(Integer code) {
        return new R(code, CodeEnum.SUCCESS.getMessage());
    }

    public static R success(String message) {
        return new R(CodeEnum.SUCCESS.getCode(), message);
    }

    public static R success(Integer code, String message) {
        return new R(code, message);
    }


    /**
     * 返回400
     *
     * @return
     */
    public static R failed() {
        return new R(CodeEnum.FAILED.getCode(), CodeEnum.FAILED.getMessage());
    }

    public static R failed(Integer code) {
        return new R(code, CodeEnum.FAILED.getMessage());
    }

    public static R failed(String message) {
        return new R(CodeEnum.FAILED.getCode(), message);
    }

    public static R failed(Integer code, String message) {
        return new R(code, message);
    }

    /**
     * 返回500
     *
     * @return
     */
    public static R error() {
        return new R(
                CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getMessage());
    }

    public static R error(Integer code) {
        return new R(
                CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getMessage());
    }

    public static R error(String message) {
        return new R(
                CodeEnum.ERROR.getCode(), message);
    }

    public static R error(Integer code, String message) {
        return new R(code, message);
    }

    /**
     * 设置
     * @param codeEnum
     * @return
     */
    public R setCodeEnum(CodeEnum codeEnum) {
        this.ret = codeEnum.getCode();
        this.message = codeEnum.getMessage();
        return this;
    }

    /**
     * 自定义返回信息
     *
     * @param message 返回信息
     * @return 返回this
     */
    public R setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * 自定义返回状态码
     *
     * @param ret 状态码
     * @return 返回this
     */
    public R setCode(Integer ret) {
        this.ret =ret;
        return this;
    }


}

