package com.sein.controller.admin;

import com.sein.enums.ResultEnum;
import com.sein.pojo.dto.PageResult;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Account;
import com.sein.pojo.po.Device;
import com.sein.pojo.po.DisplayConfig;
import com.sein.service.AccountService;
import com.sein.service.DevicePollutantService;
import com.sein.service.DeviceService;
import com.sein.service.DisplayConfigService;
import com.sein.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.util.StringUtil;

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

    @Autowired
    private DisplayConfigService displayConfigService;

    @Autowired
    private DeviceService deviceService;

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
        if (id != null) {
            Account account = accountService.getAccount(id);
            model.addAttribute("account", account);
        }
        return "background/addAccount";
    }

    @RequestMapping("/showSelectDevice")
    public String showSelectDevice() {
        return "background/selectDevice";
    }

    @RequestMapping("/devicesConfig")
    @ResponseBody
    public Result getDevicesConfig(String[] selectedDeviceId) {
        Result devicesConfig = devicePollutantService.getDevicesConfig(selectedDeviceId);
        return devicesConfig;
    }

    @PostMapping("/account")
    @Transactional
    @ResponseBody
    public Result addAccount(String displayConfigJson, String accountJson,String deviceIdStr) throws Exception{
        DisplayConfig displayConfig = JacksonUtil.readValue(displayConfigJson, DisplayConfig.class);
        if (displayConfig == null) {
            return Result.isNotOK(ResultEnum.ADD_ERROR.getInfo() + ",数据库没有对应浓度表");
        }
        //插入账户，并获取账户的id
        Account account = JacksonUtil.readValue(accountJson, Account.class);
        Integer accountId = accountService.addAccount(account);
        //displayConfig设置id
        displayConfig.setId(accountId);
        displayConfigService.addDeviceConfig(displayConfig);
        //更新添加的device
        if(StringUtils.isEmpty(deviceIdStr)){
            throw new RuntimeException();
        }
        String[] split = deviceIdStr.replace("/","").split("-");
        for (String s : split) {
            Device device = deviceService.getDevice(Integer.parseInt(s));
            device.setAccountId(accountId);
            deviceService.updateDevice(device);
        }
        return Result.isOK(ResultEnum.ADD_SUCCESS.getInfo());
    }

    @DeleteMapping("/account/{id}")
    @Transactional
    @ResponseBody
    public Result deleteAccount(@PathVariable Integer id) throws Exception{
        DisplayConfig displayConfig = displayConfigService.getDisplayConfig(id);
        if(displayConfig!=null){
            displayConfigService.deleteDisplayConfig(id);
        }
        deviceService.deleteDeviceByAccountId(id);
        return accountService.deleteAccount(id);
    }

    @PutMapping("/account")
    public String updateAccount(Account account){
        accountService.updateAccount(account);
        return "redirect:/admin/accountManage";
    }

    @GetMapping("/account/displayConfig/{id}")
    @ResponseBody
    public Result showDisplayConfig(@PathVariable Integer id){
        DisplayConfig displayConfig = displayConfigService.getDisplayConfig(id);
        return Result.isOK(JacksonUtil.toJSon(displayConfig));
    }

    @PutMapping("account/displayConfig")
    public String updateDisplayConfig(String displayConfigStr,Integer id){
        DisplayConfig displayConfig;
        if(StringUtil.isEmpty(displayConfigStr)){
            displayConfig=new DisplayConfig();
            displayConfig.setId(id);
            displayConfigService.updateDisplayConfig(displayConfig);
            return "redirect:/admin/accountManage";
        }else{
            String[] split = displayConfigStr.split(",");
            StringBuffer json=new StringBuffer("{");
            for (String s : split) {
                s="\""+s+"\"";
                json.append(s+":"+1+",");
            }
            json.deleteCharAt(json.length()-1);
            json.append("}");
            displayConfig = JacksonUtil.readValue(json.toString(), DisplayConfig.class);
            displayConfig.setId(id);
        }
        displayConfigService.updateDisplayConfig(displayConfig);
        return "redirect:/admin/accountManage";
    }
}
