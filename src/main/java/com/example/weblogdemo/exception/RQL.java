package com.example.weblogdemo.exception;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xbin
 * @description 封装客户端返回的数据 返回数据
 * @date 2021-10-14 13:36
 * @email liuhongbindeemail@gmail.com
 */
@Data
@NoArgsConstructor
public class RQL {

    private static final long serialVersionUID = 1L;

    /**
     * 响应码
     */
    private Integer ret;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 成功返回的数据
     */
    private Object data = new HashMap<>(1);


    public RQL(CodeEnum codeEnum) {
        this.ret = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public RQL(Integer ret, String message) {
        this.ret = ret;
        this.message = message;
    }

    public RQL(Integer ret, String message, Map<String, Object> data) {
        this.ret = ret;
        this.message = message;
        this.data = data;
    }

    /**
     * 使用CodeEnum模板中定义好的
     *
     * @param codeEnum
     * @return
     */
    public static RQL codeEnum(CodeEnum codeEnum) {
        return new RQL().setCodeEnum(codeEnum);
    }

    /**
     * 返回200
     *
     * @return
     */
    public static RQL success() {
        return new RQL(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMessage());
    }

    public static RQL success(Integer code) {
        return new RQL(code, CodeEnum.SUCCESS.getMessage());
    }

    public static RQL success(String message) {
        return new RQL(CodeEnum.SUCCESS.getCode(), message);
    }

    public static RQL success(Integer code, String message) {
        return new RQL(code, message);
    }


    /**
     * 返回400
     *
     * @return
     */
    public static RQL failed() {
        return new RQL(CodeEnum.FAILED.getCode(), CodeEnum.FAILED.getMessage());
    }

    public static RQL failed(Integer code) {
        return new RQL(code, CodeEnum.FAILED.getMessage());
    }

    public static RQL failed(String message) {
        return new RQL(CodeEnum.FAILED.getCode(), message);
    }

    public static RQL failed(Integer code, String message) {
        return new RQL(code, message);
    }

    /**
     * 返回500
     *
     * @return
     */
    public static RQL error() {
        return new RQL(
                CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getMessage());
    }

    public static RQL error(Integer code) {
        return new RQL(
                CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getMessage());
    }

    public static RQL error(String message) {
        return new RQL(
                CodeEnum.ERROR.getCode(), message);
    }

    public static RQL error(Integer code, String message) {
        return new RQL(code, message);
    }

    /**
     * @param map 存放数据的map
     * @return 响应的数据
     */
    public RQL setData(Map<String, Object> map) {
        this.data = map;
        return this;
    }

    /**
     * @param value 数据
     * @return 返回的数据 key-value
     */
    public RQL putData(Object value) {
        this.data = value;
        return this;
    }

    /**
     * 设置
     *
     * @param codeEnum
     * @return
     */
    public RQL setCodeEnum(CodeEnum codeEnum) {
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
    public RQL setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * 自定义返回状态码
     *
     * @param ret 状态码
     * @return 返回this
     */
    public RQL setCode(Integer ret) {
        this.ret = ret;
        return this;
    }
}

