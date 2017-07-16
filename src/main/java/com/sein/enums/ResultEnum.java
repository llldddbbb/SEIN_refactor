package com.sein.enums;

/**
 * Created by ldb on 2017/7/12.
 */
public enum ResultEnum {
    DELETE_SUCCESS(100,"删除成功"),
    UPDATE_SUCCESS(101,"更新成功"),
    ADD_SUCCESS(102,"添加成功"),

    LOGIN_INFO_NULL(0,"用户名或密码为空"),
    GPS_COLUMN_NULL(1,"浓度表没有GPS信息"),
    POLLUTANT_TABLE_NULL(2,"浓度表不存在"),


    LOGIN_ERROR(-1,"用户名或密码错误"),
    ADD_ERROR(-2,"添加失败"),
    UPDATE_ERROR(-3,"更新失败"),
    GPS_ERROR(-4,"没有查询到GPS信息"),
    DELETE_ERROR(-5,"删除失败"),
    UPLOAD_ERROR(-6,"上传失败")
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
