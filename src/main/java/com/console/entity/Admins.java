//admin的实体类

package com.console.entity;

import java.io.Serializable;

public class Admins implements Serializable {

    private static final long serialVersionUID = 1L;

    //id
    private Integer id;

    //用户名
    private String username;

    //密码
    private String password;

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
}
