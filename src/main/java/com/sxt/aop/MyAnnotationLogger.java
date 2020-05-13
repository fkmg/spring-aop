package com.sxt.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class MyAnnotationLogger {

    @Before("execution(* com.sxt.service.impl.*.*(..))")
    public void before(){
        System.out.println("前置通知......");
    }

    @AfterReturning(value = "execution(* com.sxt.service.impl.*.*(..))",returning="value")
    public void afterReturning(Object value){
        System.out.println("后置通知......");
    }

    //环绕通知
    @Around("execution(* com.sxt.service.impl.*.*(..))")
    public void around(ProceedingJoinPoint pjp) {
        System.out.println("环绕通知...begin...");
        try {
            Class<?> target = pjp.getTarget().getClass();
            System.out.println("代理的对象为："+target.getName());
            Signature signature = pjp.getSignature();
            String methodName = signature.getName();
            System.out.println(methodName);
            MethodSignature methodSignature = (MethodSignature) signature;
            pjp.proceed();//执行目标方法
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("环绕通知...end...");

    }

    @AfterThrowing(value="execution(* com.sxt.service.impl.*.*(..))",throwing="e")
    public void afterThrow(Exception e){
        System.out.println("异常通知......"+e.getMessage());
    }

    //最终通知
    @After("execution(* com.sxt.service.impl.*.*(..))")
    public void after(){
        System.out.println("最终通知.....");
    }
}
