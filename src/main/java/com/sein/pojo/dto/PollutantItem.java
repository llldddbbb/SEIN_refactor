package com.sein.pojo.dto;

/**
 * Created by ldb on 2017/3/29.
 * 每个浓度，如 NO2:153
 */
public class PollutantItem {

    //污染物类型
    private String type;
    //污染物具体值
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PollutantItem() {
    }

    public PollutantItem(String type, String value) {
        this.type = type;
        this.value = value;
    }
}
