package com.sein.pojo.dto;

import com.sein.pojo.po.Device;

import java.util.List;

/**
 * Created by ldb on 2017/7/13.
 * 对比页面的折线图类
 */
public class DevicePollutantChart {

    private Device device;
    private List<PollutantChartItem> pollutantChartItemList;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public List<PollutantChartItem> getPollutantChartItemList() {
        return pollutantChartItemList;
    }

    public void setPollutantChartItemList(List<PollutantChartItem> pollutantChartItemList) {
        this.pollutantChartItemList = pollutantChartItemList;
    }
}
