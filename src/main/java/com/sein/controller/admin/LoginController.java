package com.sein.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ldb on 2017/7/15.
 */
@Controller
public class LoginController {

    @RequestMapping("/background/login")
    public String checkLogin(){
        return "background/main";
    }

}
