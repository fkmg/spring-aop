package com.sxt.bean;

import java.util.Date;

/**
 * Created by Lenovo on 2019/11/26.
 */
public class Spouse {

    private Integer id;

    private String name;

    private Integer sex;

    private Date birth;

    private Double score;

    public Spouse() {
    }

    public Spouse(Integer id, String name, Integer sex, Date birth, Double score) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Spouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", score=" + score +
                '}';
    }
}
