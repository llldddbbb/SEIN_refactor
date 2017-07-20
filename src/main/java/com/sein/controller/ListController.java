package com.sein.controller;

import com.sein.pojo.dto.DevicePollutant;
import com.sein.pojo.po.DisplayConfig;
import com.sein.service.DevicePollutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ldb on 2017/7/12.
 * 列表页控制类
 */
@Controller
@RequestMapping("/list")
public class ListController {

    @Autowired
    private DevicePollutantService devicePollutantService;

    @RequestMapping("/devices")
    public String listDevices(HttpSession session,Model model){
        //获取配置表
        DisplayConfig displayConfig=(DisplayConfig) session.getAttribute("displayConfig");
        List<DevicePollutant> devicePollutantList=devicePollutantService.listDevicePollutant(displayConfig,null);
        for (DevicePollutant devicePollutant : devicePollutantList) {
            devicePollutantService.setInitStatus(devicePollutant);
        }
        model.addAttribute("devicePollutantList",devicePollutantList);
        return "list";
    }

    @RequestMapping("/devices/real")
    @ResponseBody
    public List<DevicePollutant> getRealTimeDevice(HttpSession session) {
        DisplayConfig displayConfig = (DisplayConfig) session.getAttribute("displayConfig");
        List<DevicePollutant> devicePollutantList=devicePollutantService.listDevicePollutant(displayConfig,null);
        for (DevicePollutant devicePollutant : devicePollutantList) {
            devicePollutantService.updateStatus(devicePollutant);
        }
        return devicePollutantList;
    }

    @RequestMapping("/search")
    public String search(HttpSession session,String cityName,Model model){
        DisplayConfig displayConfig=(DisplayConfig) session.getAttribute("displayConfig");
        List<DevicePollutant> devicePollutantList=devicePollutantService.listDevicePollutant(displayConfig,cityName);
        model.addAttribute("devicePollutantList",devicePollutantList);
        return "list";
    }

}
