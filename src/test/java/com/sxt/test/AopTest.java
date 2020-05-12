package com.sxt.test;


import com.sxt.service.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void testAop1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
        MyService myService = ac.getBean("myService",MyService.class);
        //myService.login();

        myService.testThrows(1);

    }
}
