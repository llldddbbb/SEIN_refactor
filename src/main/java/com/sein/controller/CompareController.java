package com.sein.controller;

import com.sein.pojo.dto.DevicePollutantChart;
import com.sein.pojo.po.Device;
import com.sein.pojo.po.DisplayConfig;
import com.sein.pojo.po.Duration;
import com.sein.service.DevicePollutantService;
import com.sein.service.DeviceService;
import com.sein.service.DurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ldb on 2017/7/13.
 */
@Controller
@RequestMapping("/compare")
public class CompareController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DevicePollutantService devicePollutantService;

    @Autowired
    private DurationService durationService;

    @RequestMapping("/devices")
    public String compare(HttpSession session,Model model){
        DisplayConfig displayConfig=(DisplayConfig) session.getAttribute("displayConfig");
        List<Device> deviceList=deviceService.listDevice(displayConfig.getId());
        //获取时间段
        List<Duration> durationList = durationService.listDuration(displayConfig.getId());
        model.addAttribute("durationList", durationList);
        model.addAttribute("deviceList",deviceList);
        return "compare";
    }

    @RequestMapping("/pollutantCharts")
    @ResponseBody
    public List<DevicePollutantChart> pollutantCharts(String pollutantType,String interval,String startTime,String endTime,HttpSession session){
        DisplayConfig displayConfig=(DisplayConfig) session.getAttribute("displayConfig");
        List<DevicePollutantChart> devicePollutantChartList=devicePollutantService.listDevicePollutantChart(displayConfig.getId(),pollutantType,interval,startTime,endTime);
        return devicePollutantChartList;
    }
}
