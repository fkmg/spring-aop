package com.sxt.aop;

import org.springframework.aop.ThrowsAdvice;

public class ThrowLogger implements ThrowsAdvice {

    /**
     * 匹配空指针异常
     * @param e
     */
    public void afterThrowing(NullPointerException e){
        System.out.println(e.getMessage());
    }
    /**
     * 匹配下标越界异常
     * @param e
     */
    public void afterThrowing(IndexOutOfBoundsException e){
        System.out.println(e.getMessage());
    }
}
