package com.sxt.service.impl;

import com.sxt.service.MyService;

public class MyServiceImpl implements MyService {

    public void login() {
        System.out.println("执行了MyServiceImpl中的login方法....");
    }

    public void testThrows(int flag) {
        if(flag>0){
            throw new NullPointerException("空指针异常，不能为空对象进行操作!");
        }
        throw new IndexOutOfBoundsException("下标越界异常！");
    }
}
