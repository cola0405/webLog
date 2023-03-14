package com.example.weblogdemo;

import com.alibaba.fastjson.JSON;
import com.example.weblogdemo.entity.SysRequestLog;
import com.example.weblogdemo.exception.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 日志AOP
 * @version v1.0.0
 * @author cola
 * @date 2022/4/26
 */
@Aspect
@Component
@Order(1)
public class WebLog {

    // 数据库dao
    // SysRequestLogDao sysRequestLogDao;

    final static String GET = "GET";

    @Pointcut("@annotation(com.example.weblogdemo.annotation.WebLog)")
    public void webLog() {
    }

    /**
     * @version v1.0.0
     * @author cola
     * @description 日志实现
     * @date 2022/4/22
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object result = null;
        // 日志实体类，然后记录相关信息
        SysRequestLog webLog = new SysRequestLog();

        HttpServletRequest request = getRequest();
        long startTime = System.currentTimeMillis();

        // 接口函数的method类
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

        // 日志记录请求开始时间
        webLog.setCreateTime(LocalDateTime.now());

        // 日志记录用户相关信息
        try {
            buildWebLogByRequest(webLog, request);
        } catch (Throwable t) {
            result = dealWithInvalidRequest(t, method);
            return result;
        }

        // 日志记录用户操作
        String action = getUserActionByAnnotation(method);
        webLog.setAction(action);

        // 日志记录请求参数
        recordReqParamsForWebLog(webLog, request, joinPoint);

        // 执行业务逻辑
        try {
            result = joinPoint.proceed();
        } catch (Throwable t) {
            result = dealWithError(t, webLog, method);
        }

        // 统计请求处理时长
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        webLog.setElapsedTime(elapsedTime);

        // 日志记录返回结果
        webLog.setResponse(JSON.toJSONString(result));

        // 将日志存入数据库
        // sysRequestLogDao.insert(webLog);
        return result;
    }

    /**
     * 处理系统异常
     * @param
     * @return
     */
    private Object dealWithError(Throwable t, SysRequestLog webLog, Method method) {
        Object result = null;
        t.printStackTrace();
        BusinessException e = (BusinessException) t;
        webLog.setException(e.getMessage());
        if (method.getReturnType() == R.class) {
            result = R.codeEnum(CodeEnum.FAILED).setCode(e.getCode()).setMessage(e.getMessage());
        } else if(method.getReturnType() == RQ.class) {
            result = RQ.codeEnum(CodeEnum.FAILED).setCode(e.getCode()).setMessage(e.getMessage());
        } else if(method.getReturnType() == RQL.class){
            result = RQL.codeEnum(CodeEnum.FAILED).setCode(e.getCode()).setMessage(e.getMessage());
        }
        return result;
    }

    /**
     * 记录请求参数
     *
     * @param webLog    日志实体类
     * @param request   request对象
     * @param joinPoint 切面
     * @return
     */
    void recordReqParamsForWebLog(SysRequestLog webLog, HttpServletRequest request, JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        // 获取query类型参数
        if (GET.equals(request.getMethod())) {
            webLog.setArgs(request.getQueryString());
        }

        else if (isJsonParam(request) && args.length > 0) {
            try {
                webLog.setArgs(JSON.toJSONString(args));
            } catch (Exception e) {
                CodeEnum.FAILED.assertIsNull(null);
            }
        }
    }

    boolean isJsonParam(HttpServletRequest request) {
        String contentType = request.getHeader("Content-Type");

        if (contentType != null && contentType.contains("application/json")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取到request对象
     */
    HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes
                = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return request;
    }


    /**
     * 检查是否包含query参数
     *
     * @param request request请求
     * @return
     */
    boolean hasQueryParam(HttpServletRequest request) {
        Map<String, String[]> queryParams = request.getParameterMap();
        if (queryParams.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 处理无效请求
     *
     * @param t      异常类
     * @param method 目标接口函数的method对象
     * @return
     */
    Object dealWithInvalidRequest(Throwable t, Method method) {
        BusinessException e = (BusinessException) t;
        Object result = null;

        // 根据目标接口函数不同的请求结果类，需要分别做不同的处理
        if (method.getReturnType() == R.class) {
            result = R.codeEnum(CodeEnum.FAILED).setCode(e.getCode()).setMessage(e.getMessage());
        } else if(method.getReturnType() == RQ.class) {
            result = RQ.codeEnum(CodeEnum.FAILED).setCode(e.getCode()).setMessage(e.getMessage());
        } else if(method.getReturnType() == RQL.class){
            result = RQL.codeEnum(CodeEnum.FAILED).setCode(e.getCode()).setMessage(e.getMessage());
        }
        return result;
    }

    /**
     * 通过注解获取用户正在进行的操作
     *
     * @param method 目标接口函数的method对象
     * @return
     */
    String getUserActionByAnnotation(Method method) {
        String action = null;
        try {
            action = method.getAnnotation(com.example.weblogdemo.annotation.WebLog.class).action();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return action;
    }

    /**
     * 从request中获取相关信息
     *
     * @param webLog 请求日志
     */
    public void buildWebLogByRequest(SysRequestLog webLog, HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        CodeEnum.failed_user_agent_error.assertIsNull(userAgent);

        // 获取用户id

        webLog.setUserAgent(userAgent);
        webLog.setIp(request.getRemoteAddr());
        webLog.setUrl(request.getRequestURL().toString());
        webLog.setMethod(request.getMethod());
    }
}
