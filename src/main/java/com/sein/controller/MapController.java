package com.sein.controller;

import com.sein.pojo.dto.DevicePollutant;
import com.sein.pojo.po.Device;
import com.sein.pojo.po.DisplayConfig;
import com.sein.service.DevicePollutantService;
import com.sein.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ldb on 2017/7/14.
 */
@Controller
@RequestMapping("/map")
public class MapController {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DevicePollutantService devicePollutantService;

    @RequestMapping("/devices")
    public String map(HttpSession session,Model model){
        DisplayConfig displayConfig=(DisplayConfig) session.getAttribute("displayConfig");
        List<Device> deviceList=deviceService.listDevice(displayConfig.getId());
        model.addAttribute("deviceList",deviceList);
        return "map";
    }

    @PostMapping("loadGeo")
    @ResponseBody
    public List<DevicePollutant> loadGeo(HttpSession session){
        DisplayConfig displayConfig=(DisplayConfig) session.getAttribute("displayConfig");
        //获取基本列表
        List<DevicePollutant> devicePollutantList=devicePollutantService.listDevicePollutant(displayConfig,null);
        //封装所需要的map信息
        devicePollutantService.genDevicePollutantMap(devicePollutantList);
        return devicePollutantList;
    }
}
