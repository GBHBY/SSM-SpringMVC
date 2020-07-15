package com.gyb.domian;

import java.io.Serializable;

/**
 * @Author gb
 * @Date 2020/7/11 17:10
 * @Version 1.0
 * description: 实体类
 *
 */

public class User implements Serializable {
    private String userName;
    private Integer age;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
