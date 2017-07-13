package com.sein.pojo.dto;

/**
 * Created by ldb on 2017/7/13.
 */
public class PollutantChartItem {

    //时间:横坐标
    private String time;
    //值:纵坐标
    private Double value;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
