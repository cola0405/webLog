package com.example.weblogdemo.exception;

/**
 * @CalssName IResponseEnum
 * @Author Xbin
 * @Description 状态码枚举接口实现类
 * @Date 2022-04-20 14:17
 * @Version v2.0
 * @Email liuhongbindeemail@gmail.com
*/
public interface IResponseEnum {

    /**
     * 获取状态码
     * @return
     */
    int getCode();

    /**
     * 获取提示消息
     * @return
     */
    String getMessage();

}
