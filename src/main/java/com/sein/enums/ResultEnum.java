package com.sein.enums;

/**
 * Created by ldb on 2017/7/12.
 */
public enum ResultEnum {
    LOGIN_ERROR(-1,"用户名或密码错误");

    private int state;
    private String info;

    ResultEnum(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
