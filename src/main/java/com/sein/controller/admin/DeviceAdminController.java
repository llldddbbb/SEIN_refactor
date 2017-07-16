package com.sein.controller.admin;

import com.sein.pojo.dto.GPS;
import com.sein.pojo.dto.PageResult;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Device;
import com.sein.pojo.po.DisplayConfig;
import com.sein.service.DevicePollutantService;
import com.sein.service.DeviceService;
import com.sein.service.DisplayConfigService;
import com.sein.service.PollutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    private PollutantService pollutantSerivce;

    @RequestMapping("/deviceManage")
    public String deviceManagePage() {
        return "background/deviceManage";
    }

    @RequestMapping("/addDevice")
    public String addDevicePage(Integer id, Model model) {
        if(id!=null){
            Device device = deviceService.getDevice(id);
            model.addAttribute("device",device);
        }
        return "background/addDevice";
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

    @PostMapping("/device/manage")
    @ResponseBody
    public Result operateDevice(Device device){
        //判断表格是否存在
        Result existPollutantTable = pollutantSerivce.isExistPollutantTable(device.getPollutantTable());
        //不存在则返回
        if(!existPollutantTable.isSuccess()){
            return existPollutantTable;
        }
        if(device.getId()!=null){
            return deviceService.updateDevice(device);
        }else{
            return deviceService.addDevice(device);
        }
    }

}
