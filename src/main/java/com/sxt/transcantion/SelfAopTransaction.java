package com.sxt.transcantion;


import com.sxt.annotion.ExtTransaction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

import java.lang.reflect.Method;

@Aspect
@Component
public class SelfAopTransaction {

    @Autowired
    private SelfTransactionManager selfTransactionManager;


    private static Log log = LogFactory.getLog(SelfAopTransaction.class);


    @Around("execution(* com.sxt.service.impl.*.*(..))")
    public Object arround(ProceedingJoinPoint pjo) throws Throwable {

        TransactionStatus transactionStatus = null;

        //扫描注解
        ExtTransaction transaction = this.getTransactionStatus(pjo);

        if(transaction !=null){
            //开启事务
            transactionStatus = selfTransactionManager.begin(transaction.qualifier());
        }
        //执行方法
        Object result = pjo.proceed();

        //提交事务
        if(transactionStatus !=null){
            selfTransactionManager.commit(transactionStatus);
        }

        return result;

    }




    /**
     *根据相应参数扫描方法获取相应注解
     * @param pjo
     * @return
     */
    public ExtTransaction getTransactionStatus(ProceedingJoinPoint pjo){
        //1、获取方法名
        String methoName = pjo.getSignature().getName();
        //2、获取参数列表
        Class<?>[] args = ((MethodSignature) pjo.getSignature()).getParameterTypes();
        //3、获取对象
        Class<?> objClass = pjo.getTarget().getClass();

        for(int i = 0;i<args.length;i++){
            System.out.println(args[i].getName());
        }

        Method method = null;
        try {
            method = objClass.getDeclaredMethod(methoName, args);
            //4、获取相应的注解
            ExtTransaction annotation = method.getAnnotation(ExtTransaction.class);
            if(annotation !=null){
                return annotation;
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
