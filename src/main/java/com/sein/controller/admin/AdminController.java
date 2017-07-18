package com.sein.controller.admin;

import com.sein.enums.ResultEnum;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Admin;
import com.sein.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ldb on 2017/7/15.
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("admin/main")
    public String goMain(){
        return "background/main";
    }


    @PostMapping("/background/login")
    @ResponseBody
    public Result login(Admin admin) {
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(admin.getAdminName(), admin.getPassword());
        try{
            subject.login(token);//登录验证
            return Result.isOK();
        }catch(Exception e){
            //登录失败
            return Result.isNotOK(ResultEnum.LOGIN_ERROR.getInfo());
        }
    }



}
