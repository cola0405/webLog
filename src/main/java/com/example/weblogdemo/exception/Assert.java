package com.example.weblogdemo.exception;

/**
* @author Xbin
* @description 断言异常
* @date 2021-10-13 16:05
* @email liuhongbindeemail@gmail.com
*/
public interface Assert {
    /**
     * 创建异常
     * @param args
     * @return
     */
    BaseException newException(Object... args);

    /**
     * 创建异常
     * @param t
     * @param args
     * @return
     */
    BaseException newException(Throwable t, Object... args);

    /**
     * 判断对象是否为空，为空则抛出异常
     *
     * @param obj 待判断对象
     */
    default void assertIsNull(Object obj) {
        if (obj == null) {
            throw newException(obj);
        }
    }

    /**
     * 判断字符串为空
     * @param str
     */
    default void assertIsStringNull(String str){
        if (str==null||str.length()==0){
            throw newException(str);

        }
    }

    /**
     * 判断对象是否为空，为空则抛出异常
     *
     * @param obj 待判断对象
     */
    default void assertNotNull(Object obj) {
        if (obj != null) {
            throw newException(obj);
        }
    }

    /**
     *判断bool是否为true  true 抛出异常
     * @param bool
     */
    default void assertIsTrue(Boolean bool) {
        if (bool) {
            throw newException();
        }
    }

    /**
     *判断bool是否为false  false 抛出异常
     * @param bool
     */
    default void assertIsFalse(Boolean bool) {
        if (!bool) {
            throw newException();
        }
    }


    /**
     *判断bool是否为false  false 抛出异常
     * @param bool
     */
    default void assertIsIntFalse(int bool) {
        if (bool==0) {
            throw newException();
        }
    }

    /**
     *判断bool是否为false  false 抛出异常
     * @param bool
     */
    default void assertIsIntTrue(int bool) {
        if (bool!=0) {
            throw newException();
        }
    }
    /**
     * 判断两个对象是否相等   相等抛出异常
     *
     * @param s1 待判断对象
     * @param s2 待判断对象
     */
    default void assertIsEquals(Object s1, Object s2){
        if (s1==null){
            throw newException();
        }
        if (s2==null){
            throw newException();
        }
        if (s1.equals(s2)){
            throw newException();
        }
    }
    /**
     * 判断两个对象是否不相等  不相等抛出异常
     *
     * @param s1 待判断对象
     * @param s2 待判断对象
     */
    default void assertNotEquals(Object s1, Object s2){
        if (s1==null){
            throw newException();
        }
        if (s2==null){
            throw newException();
        }
        if (!s1.equals(s2)){
            throw newException();
        }
    }


    /**
     * <p>断言对象<code>obj</code>非空。如果对象<code>obj</code>为空，则抛出异常
     * <p>异常信息<code>message</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param obj 待判断对象
     * @param args message占位符对应的参数列表
     */
    default void assertIsNull(Object obj, Object... args) {
        if (obj == null) {
            throw newException(args);
        }
    }



    /**
     * <p>断言对象<code>obj</code>非空。如果对象<code>obj</code>为空，则抛出异常
     * <p>异常信息<code>message</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param obj 待判断对象
     * @param args message占位符对应的参数列表
     */
    default void assertNotNull(Object obj, Object... args) {
        if (obj != null) {
            throw newException(args);
        }
    }


}
