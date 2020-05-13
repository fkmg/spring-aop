package com.sxt.dao.impl;

import com.sxt.bean.Spouse;
import com.sxt.dao.SpouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Lenovo on 2019/11/26.
 */
@Repository
public class SpouseDaoImpl implements SpouseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int add(Spouse sp) {
        String sql = "INSERT INTO spouse(NAME,sex,birth,score)VALUES(?,?,?,?)";
        int n = jdbcTemplate.update(sql, sp.getName(), sp.getSex(), sp.getBirth(), sp.getScore());
        return n;
    }
}
