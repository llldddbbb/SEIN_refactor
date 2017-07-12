package com.sein.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ldb on 2017/3/28.
 */
@Controller
public class DefaultController {

    @RequestMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }
}
