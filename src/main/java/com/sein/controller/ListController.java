package com.sein.controller;

import com.sein.pojo.dto.DevicePollutant;
import com.sein.pojo.po.DisplayConfig;
import com.sein.service.DevicePollutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ldb on 2017/7/12.
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
        List<DevicePollutant> devicePollutantList=devicePollutantService.listDevicePollutant(displayConfig);
        model.addAttribute("devicePollutantList",devicePollutantList);
        return "list";
    }

}
