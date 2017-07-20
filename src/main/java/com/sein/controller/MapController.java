package com.sein.controller;

import com.sein.pojo.dto.DevicePollutant;
import com.sein.pojo.dto.GPS;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Device;
import com.sein.pojo.po.DisplayConfig;
import com.sein.service.DevicePollutantService;
import com.sein.service.DeviceService;
import com.sein.service.DisplayConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private DisplayConfigService displayConfigService;

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
        devicePollutantService.setDevicePollutantMap(devicePollutantList,displayConfig);
        return devicePollutantList;
    }

    @GetMapping("/update/gps")
    @ResponseBody
    public Result updateDeviceGPS(Integer accountId){
        Result result=null;
        List<Device> deviceList = deviceService.listDevice(accountId);
        for (Device device : deviceList) {
            //获取DisplayConfig参数
            DisplayConfig displayConfig = displayConfigService.getDisplayConfig(device.getAccountId());
            result = devicePollutantService.getDeviceNewestGPS(displayConfig,device);
            //是否成功查询GPS信息
            if(result.isSuccess()){
                GPS gps=(GPS)result.getData();
                result=deviceService.updateDeviceGPS(device,gps);
            }else{
                return result;
            }
        }
        return result;
    }
}
