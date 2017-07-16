package com.sein.controller;

import com.sein.controller.utils.ResponseUtil;
import com.sein.pojo.dto.PollutantTable;
import com.sein.pojo.po.Device;
import com.sein.pojo.po.DisplayConfig;
import com.sein.service.DeviceService;
import com.sein.service.PollutantService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ldb on 2017/7/13.
 */
@Controller
@RequestMapping("/table")
public class TableController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private PollutantService pollutantService;

    @RequestMapping("/devices")
    public String table(HttpSession session, Model model){
        DisplayConfig displayConfig=(DisplayConfig) session.getAttribute("displayConfig");
        List<Device> deviceList=deviceService.listDevice(displayConfig.getId());
        model.addAttribute("deviceList",deviceList);
        return "table";
    }

    @RequestMapping("/pollutantTable")
    @ResponseBody
    public PollutantTable pollutantTable(Integer id, String interval,@RequestParam(required = false) String page,
                                 @RequestParam(required = false) String startTime, @RequestParam(required = false) String endTime,
                                 @RequestParam(required = false) String pollutantTypeAndAlerm,@RequestParam(required = false) String unit){
        Device device = deviceService.getDevice(id);
        PollutantTable pollutantTable=pollutantService.getPollutantTable(device,interval,page,startTime,endTime,unit,pollutantTypeAndAlerm);
        return pollutantTable;
    }

    @RequestMapping("exportExcel")
    public void exportExcel(Integer id, String interval, @RequestParam(required = false) String startTime, @RequestParam(required = false) String endTime,
                            @RequestParam(required = false) String pollutantTypeAndAlerm, @RequestParam(required = false) String unit,HttpServletResponse response)throws Exception{
        Device device = deviceService.getDevice(id);
        Workbook wb=pollutantService.getPollutantExcel(device,interval,startTime,endTime,unit,pollutantTypeAndAlerm);
        ResponseUtil.exportExcel(response,wb,device.getPollutantTable()+"_"+device.getCityName()+interval+".xls");
    }


}
