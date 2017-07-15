package com.sein.controller.admin;

import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Admin;
import com.sein.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ldb on 2017/7/15.
 */
@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/background/login")
    @ResponseBody
    public Result checkLogin(Admin admin){
        Result result = adminService.checkLogin(admin);
        return result;
    }

}
