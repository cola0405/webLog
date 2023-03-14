package com.example.weblogdemo.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 日志实体类
 * @version v1.0.0
 * @author cola
 * @date 2022/4/26
 */
@Data
public class SysRequestLog {
    Integer id;

    /**
     * 用户名
     */
    Integer userId;

    /**
     * 客户端
     */
    String userAgent;

    /**
     * 请求url
     */
    String url;

    /**
     * 用户操作
     */
    String action;

    String ip;

    /**
     * 请求方法
     */
    String method;

    /**
     * 请求参数
     */
    String args;

    /**
     * 异常信息
     */
    String exception;

    /**
     * 返回结果
     */
    String response;

    /**
     * 处理请求所耗费的时间
     */
    long elapsedTime;

    /**
     * 请求开始的时间
     */
    LocalDateTime createTime;
}
