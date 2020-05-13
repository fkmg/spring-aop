package com.sxt.service.impl;

import com.sxt.annotion.ExtTransaction;
import com.sxt.bean.Spouse;
import com.sxt.dao.SpouseDao;
import com.sxt.service.SpouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Lenovo on 2019/11/26.
 */
@Service
public class SpouseServiceImpl implements SpouseService{

    @Autowired
    private SpouseDao spouseDao;

    /*@Transactional
	public void add(){
		userDao.add("user3",20);
		int d = 1/0;
		System.out.println("插入；额一条数据 &&&&&&&");
		userDao.add("user4", 26);
	}*/

    @ExtTransaction(qualifier = "transactionManager")
    @Override
    public int add(Spouse sp){
        int m = spouseDao.add(sp);
        System.out.println(m);
        int i = 1/0;
        return m;
    }
}
