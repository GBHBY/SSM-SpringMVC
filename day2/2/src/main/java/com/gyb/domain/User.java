package com.gyb.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author gb
 * @Date 2020/7/8 16:21
 * @Version 1.0
 * description:
 */

public class User implements Serializable {
    private String userName;
    private Integer age;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
