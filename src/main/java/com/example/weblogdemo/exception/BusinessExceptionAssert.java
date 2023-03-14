package com.example.weblogdemo.exception;


/**
 * 实现了Assert的newException方法  返回一个自定义业务异常 该异常的父类继承了runtimeException异常
 * 把所有的接口放到了一起。
 *
 * @author Xbin
 * @description 业务异常
 * @date 2021-10-13 14:52
 * @email liuhongbindeemail@gmail.com
 */
public interface BusinessExceptionAssert extends IResponseEnum, Assert {

    /**
     * 重写了异常的抛出
     *
     * @param args
     * @return
     */
    @Override
    default BaseException newException(Object... args) {
        return new BusinessException(this, args);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        return null;
    }
}
