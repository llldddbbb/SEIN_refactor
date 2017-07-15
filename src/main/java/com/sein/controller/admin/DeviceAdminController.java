package com.sein.controller.admin;

import com.sein.pojo.dto.PageResult;
import com.sein.pojo.po.Device;
import com.sein.service.DeviceService;
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

}
