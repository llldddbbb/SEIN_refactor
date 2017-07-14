package com.sein.controller;

import com.sein.enums.ResultEnum;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Account;
import com.sein.pojo.po.DisplayConfig;
import com.sein.pojo.po.Duration;
import com.sein.service.AccountService;
import com.sein.service.DisplayConfigService;
import com.sein.service.DurationService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @Autowired
    private DurationService durationService;


    @PostMapping("/login")
    @ResponseBody
    public Result login(Account account, HttpSession session) {
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(account.getUserName(), account.getPassword());
        try{
            subject.login(token);//登录验证
            Account currentAccount=(Account) SecurityUtils.getSubject().getSession().getAttribute("currentAccount");
            //将配置信息存入session中
            DisplayConfig displayConfig = displayConfigService.getDisplayConfig(currentAccount.getId());
            SecurityUtils.getSubject().getSession().setAttribute("displayConfig", displayConfig);
            //获取时间段
            List<Duration> durationList = durationService.listDuration(displayConfig.getId());
            SecurityUtils.getSubject().getSession().setAttribute("durationList", durationList);
            return Result.isOK();
        }catch(Exception e){
            //登录失败
            return Result.isNotOK(ResultEnum.LOGIN_ERROR.getInfo());
        }
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
        }
        return "login";
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
