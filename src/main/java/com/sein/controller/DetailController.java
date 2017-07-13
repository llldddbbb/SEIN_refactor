package com.sein.controller;

import com.sein.pojo.dto.DevicePollutant;
import com.sein.pojo.po.DisplayConfig;
import com.sein.service.DevicePollutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by ldb on 2017/7/13.
 * 详情页的Controller
 */
@Controller
@RequestMapping("/detail")
public class DetailController {
    
    @Autowired
    private DevicePollutantService devicePollutantService;

    @RequestMapping("/devices/{id}")
    public String getDevices(@PathVariable("id")Integer id, HttpSession session,Model model){
        DisplayConfig displayConfig=(DisplayConfig) session.getAttribute("displayConfig");
        DevicePollutant devicePollutant = devicePollutantService.getDevicePollutantById(displayConfig,id);
        model.addAttribute("devicePollutant",devicePollutant);
        return "detail";
    }
}
