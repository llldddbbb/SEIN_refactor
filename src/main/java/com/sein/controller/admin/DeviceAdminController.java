package com.sein.controller.admin;

import com.sein.pojo.dto.GPS;
import com.sein.pojo.dto.PageResult;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Device;
import com.sein.pojo.po.DisplayConfig;
import com.sein.service.DevicePollutantService;
import com.sein.service.DeviceService;
import com.sein.service.DisplayConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ldb on 2017/7/15.
 */
@Controller
@RequestMapping("/admin")
public class DeviceAdminController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DevicePollutantService devicePollutantService;

    @Autowired
    private DisplayConfigService displayConfigService;

    @RequestMapping("/deviceManage")
    public String deviceManagePage() {
        return "background/deviceManage";
    }

    @GetMapping("/device/list/{page}")
    @ResponseBody
    public PageResult<Device> getDeviceList(@PathVariable Integer page, Integer pageSize) {
        //获取评论列表
        PageResult<Device> pageResult = deviceService.listDevice(page, pageSize);
        return pageResult;
    }

    @PutMapping("/device/{id}/gps")
    @ResponseBody
    public Result updateDeviceGPS(@PathVariable Integer id){
        //获取DisplayConfig参数
        Device device = deviceService.getDevice(id);
        DisplayConfig displayConfig = displayConfigService.getDisplayConfig(device.getAccountId());
        Result deviceNewestGPS = devicePollutantService.getDeviceNewestGPS(displayConfig,device);
        //是否成功查询GPS信息
        if(deviceNewestGPS.isSuccess()){
            GPS gps=(GPS)deviceNewestGPS.getData();
            return deviceService.updateDeviceGPS(device,gps);
        }else{
            return deviceNewestGPS;
        }
    }

}
