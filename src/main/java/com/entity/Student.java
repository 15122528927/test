package com.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Student {

    private int id;
    private String name;
    private String sex;

    private Date date;

    private Boolean ifrom;


    public Student(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Boolean getIfrom() {
        return ifrom;
    }

    public void setIfrom(Boolean ifrom) {
        this.ifrom = ifrom;
    }


    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
