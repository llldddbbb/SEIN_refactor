package com.sein.enums;

/**
 * Created by ldb on 2017/7/12.
 */
public enum ResultEnum {
    UPDATE_SUCCESS(1,"更新成功"),
    ADD_SUCCESS(0,"添加成功"),
    LOGIN_ERROR(-1,"用户名或密码错误"),
    LOGIN_INFO_NULL(-2,"用户名或密码为空"),
    ADD_ERROR(-3,"添加失败"),
    UPDATE_ERROR(-4,"更新失败"),
    GPS_COLUMN_NULL(-5,"浓度表没有GPS信息"),
    GPS_ERROR(-6,"没有查询到GPS信息"),
    POLLUTANT_TABLE_NULL(-7,"浓度表不存在")
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
