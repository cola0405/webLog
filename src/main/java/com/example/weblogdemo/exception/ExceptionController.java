package com.example.weblogdemo.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * @author Xbin
 * @description 统一异常处理
 * @date 2021-10-13 21:14
 * @email liuhongbindeemail@gmail.com
 */
@Slf4j
@RestControllerAdvice
public class ExceptionController {

    /**
     *      * @Description: 文件上传过大异常
     *      * @param ex
     *      * @return
     *      
     */
    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    @ResponseBody
    public R processException(MaxUploadSizeExceededException e) {

        if (e.getCause().getCause() instanceof FileSizeLimitExceededException){//单个文件大小超出限制抛出的异常
            log.error("message异常信息为=========》"+e.getMessage());
            log.error("cause异常信息为=========》"+e.getCause().getCause());
            return R.codeEnum(CodeEnum.failed_file_siez_over);

        }else if (e.getCause().getCause() instanceof SizeLimitExceededException){//总文件大小超出限制抛出的异常
            log.error("message异常信息为=========》"+e.getMessage());
            log.error("cause异常信息为=========》"+e.getCause().getCause());

            return R.codeEnum(CodeEnum.failed_file_siez_over);
        }
        return R.codeEnum(CodeEnum.failed_file_siez_over);
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public R handleBusinessException(BusinessException e, HttpServletRequest request) {
        e.printStackTrace();
        log.error("业务异常:" + e.getMessage());
        return R.failed(e.getCode(), e.getMessage());
    }

    /**
     * 校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public R catchConstraintViolationException(BindException e) {
        StringBuffer result = new StringBuffer("");
        e.getAllErrors().stream().forEach(k -> {
            result.append(k.getDefaultMessage());
        });
        log.info("传递参数错误:\n\r" + result);
        return R.codeEnum(CodeEnum.failed_parameter_wrong).setMessage(result.toString());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public R catchHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        log.info("请求方法错误："+e);
        return R.codeEnum(CodeEnum.failed_request_method_failed);
    }
    /**
     * 在controller层校验异常的时候
     *
     * @param con
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public R catchConstraintViolationException(ConstraintViolationException con) {
        StringBuffer result = new StringBuffer("");
        con.getConstraintViolations().stream().forEach(c -> {
            result.append(c.getMessage() + ",");
        });
        log.info("传递参数错误:\n\r" + result);
        return R.codeEnum(CodeEnum.failed_parameter_wrong).setMessage(result.toString());
    }

    /**
     * 参数验证异常， 在controller中没有写result参数时，会进入
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public R handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = "";
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getDefaultMessage();
            }
        }
        log.error(e.getMessage());
        log.error("参数异常:" + message);
        return R.codeEnum(CodeEnum.failed_parameter_wrong).setMessage(message);
    }
    /**
     * 参数验证异常， 在controller中没有写result参数时，会进入
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MissingRequestHeaderException.class)
    @ResponseBody
    public R handleHeaderException(MissingRequestHeaderException e) {
        log.info("header缺失:\n\r" + e.getHeaderName());
        return R.codeEnum(CodeEnum.failed_parameter_wrong).setMessage("header缺失:" + e.getHeaderName());
    }

    /**
     * Content-Type异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public R handleParamException(HttpMediaTypeNotSupportedException e) {
        log.info("Content-Type不正确\n\r");
        return R.codeEnum(CodeEnum.failed_parameter_wrong).setMessage("Content-Type不正确");
    }

    /**
     * 捕获其他的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R catchAllException(Exception e) {
        log.error(e.getMessage());
        if (e instanceof InvalidFormatException) {
            // 如果是未登录异常
            return R.codeEnum(CodeEnum.failed_token.setMessage("账号未登录"));
        } else if (e instanceof InvalidFormatException) {
            return R.codeEnum(CodeEnum.failed_parameter_wrong);
        } else if (e instanceof HttpMessageNotReadableException) {
            return R.codeEnum(CodeEnum.failed_parameter_wrong);
        }else if(e instanceof HttpMediaTypeNotSupportedException){
            R.codeEnum(CodeEnum.failed_param_should_be_json_form);
        }
        e.printStackTrace();
        log.error("\n\r系统异常!", e);
        return R.codeEnum(CodeEnum.ERROR);
    }


}
