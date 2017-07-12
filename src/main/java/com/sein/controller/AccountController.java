package com.sein.controller;

import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Account;
import com.sein.pojo.po.DisplayConfig;
import com.sein.service.AccountService;
import com.sein.service.DisplayConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by ldb on 2017/7/12.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountService accountService;

    @Autowired
    private DisplayConfigService displayConfigService;

    @PostMapping("/login")
    @ResponseBody
    public Result login(Account account, HttpSession session) {
        Result result = accountService.checkLogin(account);
        if (result.isSuccess()) {
            //将当前用户存入session中
            Account currentAccount = (Account) result.getData();
            session.setAttribute("currentAccount", currentAccount);
            //将配置信息存入session中
            DisplayConfig displayConfig = displayConfigService.getDisplayConfig(currentAccount.getId());
            session.setAttribute("displayConfig", displayConfig);
        }
        return result;
    }

    @PostMapping("/add")
    @ResponseBody
    public Result addAccount(Account account) {
        return accountService.addAccount(account);
    }

    @PostMapping("/update")
    @ResponseBody
    public Result updateAccount(Account account) {
        return accountService.updateAccount(account);
    }
}
