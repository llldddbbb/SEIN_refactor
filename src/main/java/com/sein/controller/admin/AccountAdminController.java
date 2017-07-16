package com.sein.controller.admin;

import com.sein.pojo.dto.PageResult;
import com.sein.pojo.po.Account;
import com.sein.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/accountManage")
    public String accountManagePage() {
        return "background/accountManage";
    }

    @GetMapping("/account/list/{page}")
    @ResponseBody
    public PageResult<Account> getDeviceList(@PathVariable Integer page, Integer pageSize) {
        //获取分页列表
        PageResult<Account> pageResult = accountService.listAccount(page, pageSize);
        return pageResult;
    }
}
