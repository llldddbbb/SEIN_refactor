package com.sein.enums;

/**
 * Created by ldb on 2017/7/12.
 */
public enum ResultEnum {
    LOGIN_ERROR(-1,"用户名或密码错误"),
    LOGIN_INFO_NULL(-2,"用户名或密码为空"),
    UPDATE_ERROR(-3,"更新失败"),
    GPS_COLUMN_NULL(-4,"浓度表没有GPS信息"),
    GPS_ERROR(-5,"没有查询到GPS信息")
    ;

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
