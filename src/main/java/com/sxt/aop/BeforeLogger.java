package com.sxt.aop;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Date;

public class BeforeLogger implements MethodBeforeAdvice  {


    /**
     * 参数method: 被代理的方法对象
     * 参数args: 被代理的方法执行时需要的参数,如果方法没有执行参数, args值是长度为0的空数组
     * 参数target: 被代理的对象
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        Date now = new Date();
        String time = DateFormatUtils.format(now, "yyyy-MM-dd HH:mm:ss");

        System.out.println(time +o.getClass().getName()+"执行了"+method.getName()+"方法");
    }
}
