package com.gyb.domain;

import java.io.Serializable;

/**
 * @Author gb
 * @Date 2020/7/15 19:14
 * @Version 1.0
 * description:实体类
 */

public class Account implements Serializable {
    private Integer id;
    private String name;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
