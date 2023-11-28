package com.ra.model.entity;

import java.sql.Date;

public class Student {
    private int id;
    private String name;
    private String email;
    private Date birthday;
    private String address;

    public Student(int id, String name, String email, Date birthday, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
    }

    public Student() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
