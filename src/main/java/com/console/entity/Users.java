//users的实体类

package com.console.entity;

import java.io.Serializable;

public class Users implements Serializable{

    private static final long serialVersionUID = 1L;

    //id
    private Integer id;

    //用户名
    private String username;

    //密码
    private String password;

    //姓名
    private String name;

    //性别
    private String gender;

    //电话号码
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
