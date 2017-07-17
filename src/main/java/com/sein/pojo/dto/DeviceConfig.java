package com.sein.pojo.dto;

import com.sein.pojo.po.Device;

import java.util.List;
import java.util.TreeSet;

/**
 * Created by ldb on 2017/7/17.
 */
public class DeviceConfig {

    List<Device> deviceList;
    //浓度参数
    TreeSet<String> pollutantConfig=new TreeSet<>();
    //分辨率参数
    TreeSet<String> intervalConfig=new TreeSet<>();

    public TreeSet<String> getPollutantConfig() {
        return pollutantConfig;
    }

    public void setPollutantConfig(TreeSet<String> pollutantConfig) {
        this.pollutantConfig = pollutantConfig;
    }

    public TreeSet<String> getIntervalConfig() {
        return intervalConfig;
    }

    public void setIntervalConfig(TreeSet<String> intervalConfig) {
        this.intervalConfig = intervalConfig;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }
}
