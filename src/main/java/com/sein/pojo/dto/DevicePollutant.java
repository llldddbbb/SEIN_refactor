package com.sein.pojo.dto;

import com.sein.pojo.po.Device;

import java.util.List;

/**
 * Created by ldb on 2017/3/29.
 * 设备和浓度类
 */
public class DevicePollutant {

    private Device device;

    private List<PollutantItem> pollutantItemList;

    //离线在线状态
    private Integer status;

    //AQI与AQHI
    private String AQI;

    private String AQHI;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public List<PollutantItem> getPollutantItemList() {
        return pollutantItemList;
    }

    public void setPollutantItemList(List<PollutantItem> pollutantItemList) {
        this.pollutantItemList = pollutantItemList;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAQI() {
        return AQI;
    }

    public void setAQI(String AQI) {
        this.AQI = AQI;
    }

    public String getAQHI() {
        return AQHI;
    }

    public void setAQHI(String AQHI) {
        this.AQHI = AQHI;
    }
}
