package com.sein.controller.admin;

import com.sein.pojo.dto.PageResult;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Account;
import com.sein.service.AccountService;
import com.sein.service.DevicePollutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ldb on 2017/7/16.
 */
@Controller
@RequestMapping("/admin")
public class AccountAdminController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private DevicePollutantService devicePollutantService;

    @RequestMapping("/accountManage")
    public String accountManagePage() {
        return "background/accountManage";
    }

    @GetMapping("/account/list/{page}")
    @ResponseBody
    public PageResult<Account> getAccountList(@PathVariable Integer page, Integer pageSize) {
        //获取分页列表
        PageResult<Account> pageResult = accountService.listAccount(page, pageSize);
        return pageResult;
    }


    @RequestMapping("/addAccount")
    public String addAccountPage(Integer id, Model model) {
        if(id!=null){
            Account account = accountService.getAccount(id);
            model.addAttribute("account",account);
        }
        return "background/addAccount";
    }

    @RequestMapping("/showSelectDevice")
    public String showSelectDevice(){
        return "background/selectDevice";
    }

    @RequestMapping("/devicesConfig")
    @ResponseBody
    public Result getDevicesConfig(String[] selectedDeviceId){
        Result devicesConfig = devicePollutantService.getDevicesConfig(selectedDeviceId);
        return devicesConfig;
    }
}
