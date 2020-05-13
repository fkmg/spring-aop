package com.sxt.test;

import com.sxt.bean.Spouse;
import com.sxt.service.SpouseService;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Lenovo on 2019/11/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTranscation {

    @Autowired
    private SpouseService spouseService;

    @Test
    public void test(){
        Spouse sp = new Spouse();
        sp.setName("yhj");
        sp.setScore(99.00);
        sp.setSex(1);
        Date now = new Date();
        Date birth = DateUtils.addYears(now, -25);
        sp.setBirth(birth);
        spouseService.add(sp);
    }
}
