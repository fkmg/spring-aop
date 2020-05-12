package com.sxt.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class ArroundLogger implements MethodInterceptor {

    /**
     * 参数invocation: 方法执行器对象, 此对象中包含被代理的方法的所有信息.
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Method method = methodInvocation.getMethod();
        System.out.println(method.getName());
        Class<?> classparent = method.getDeclaringClass();
        System.out.println(classparent.getName());
        System.out.println("环绕通知......before.....");
        Object value = methodInvocation.proceed();//执行被代理目标方法或其他的通知
        System.out.println("环绕通知.....after....");
        return value;
    }
}
