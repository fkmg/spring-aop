package com.sxt.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterLogger implements AfterReturningAdvice {

    /**
     * 参数returnValue: 被代理的方法执行后的返回值
     * 参数method: 被代理的方法对象
     * 参数args: 被代理的方法执行时需要的参数,如果方法没有执行参数, args值是长度为0的空数组
     * 参数target: 被代理的对象
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("为方法 \"" + method.getName() + "\" 增加后置通知日志处理 ... ; 本方法的返回值为 : " + returnValue);
    }
}
