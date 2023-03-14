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
public class RQ {

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
    private Map<String, Object> data = new HashMap<>(1);


    public RQ(CodeEnum codeEnum) {
        this.ret = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public RQ(Integer ret, String message) {
        this.ret = ret;
        this.message = message;
    }

    public RQ(Integer ret, String message, Map<String, Object> data) {
        this.ret = ret;
        this.message = message;
        this.data = data;
    }

    /**
     * 使用CodeEnum模板中定义好的
     * @param codeEnum
     * @return
     */
    public static RQ codeEnum(CodeEnum codeEnum) {
        return new RQ().setCodeEnum(codeEnum);
    }

    /**
     * 返回200
     *
     * @return
     */
    public static RQ success() {
        return new RQ(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMessage());
    }

    public static RQ success(Integer code) {
        return new RQ(code, CodeEnum.SUCCESS.getMessage());
    }

    public static RQ success(String message) {
        return new RQ(CodeEnum.SUCCESS.getCode(), message);
    }

    public static RQ success(Integer code, String message) {
        return new RQ(code, message);
    }


    /**
     * 返回400
     *
     * @return
     */
    public static RQ failed() {
        return new RQ(CodeEnum.FAILED.getCode(), CodeEnum.FAILED.getMessage());
    }

    public static RQ failed(Integer code) {
        return new RQ(code, CodeEnum.FAILED.getMessage());
    }

    public static RQ failed(String message) {
        return new RQ(CodeEnum.FAILED.getCode(), message);
    }

    public static RQ failed(Integer code, String message) {
        return new RQ(code, message);
    }

    /**
     * 返回500
     *
     * @return
     */
    public static RQ error() {
        return new RQ(
                CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getMessage());
    }

    public static RQ error(Integer code) {
        return new RQ(
                CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getMessage());
    }

    public static RQ error(String message) {
        return new RQ(
                CodeEnum.ERROR.getCode(), message);
    }

    public static RQ error(Integer code, String message) {
        return new RQ(code, message);
    }

    /**
     * @param map 存放数据的map
     * @return 响应的数据
     */
    public RQ setData(Map<String, Object> map) {
        this.data = map;
        return this;
    }

    /**
     * @param key   参数名
     * @param value 数据
     * @return 返回的数据 key-value
     */
    public RQ putData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    /**
     * 设置
     * @param codeEnum
     * @return
     */
    public RQ setCodeEnum(CodeEnum codeEnum) {
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
    public RQ setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * 自定义返回状态码
     *
     * @param ret 状态码
     * @return 返回this
     */
    public RQ setCode(Integer ret) {
        this.ret =ret;
        return this;
    }
}

