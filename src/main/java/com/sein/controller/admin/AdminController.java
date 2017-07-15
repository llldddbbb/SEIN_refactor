package com.sein.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ldb on 2017/7/15.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/main")
    public String goMain(){
        return "background/main";
    }

}
