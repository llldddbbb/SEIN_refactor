package com.sein.pojo.po;

import javax.persistence.Column;

/**
 * Created by ldb on 2017/7/12.
 */
public class Admin {

    //主键
    private Integer id;
    //用户名
    @Column(name = "adminName")
    private String adminName;
    //密码
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
