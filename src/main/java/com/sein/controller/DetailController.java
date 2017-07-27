package com.sein.controller;

import com.sein.pojo.dto.DevicePollutant;
import com.sein.pojo.dto.PollutantChartItem;
import com.sein.pojo.po.DisplayConfig;
import com.sein.service.DevicePollutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public String getDevices(@PathVariable("id") Integer id, HttpSession session, Model model) {
        DisplayConfig displayConfig = (DisplayConfig) session.getAttribute("displayConfig");
        DevicePollutant devicePollutant = devicePollutantService.getDevicePollutantById(displayConfig, id);
        model.addAttribute("devicePollutant", devicePollutant);
        return "detail";
    }

    @RequestMapping("/devices/real/{id}")
    @ResponseBody
    public DevicePollutant getRealTimeDevice(@PathVariable("id") Integer id, HttpSession session) {
        DisplayConfig displayConfig = (DisplayConfig) session.getAttribute("displayConfig");
        DevicePollutant devicePollutant = devicePollutantService.getDevicePollutantById(displayConfig, id);
        return devicePollutant;
    }

    @RequestMapping("/chart")
    @ResponseBody
    public List<PollutantChartItem> getChart(Integer id, @RequestParam(required = false) String pollutantType,
                           @RequestParam(required = false) String startTime, @RequestParam(required = false) String endTime,
                           @RequestParam(required = false) String interval) {
        if (pollutantType == null) {
            pollutantType = "PM25";
        }
        List<PollutantChartItem> pollutantChartList = devicePollutantService.listPollutantChart( id, pollutantType, startTime, endTime, interval);
        return pollutantChartList;
    }
}


