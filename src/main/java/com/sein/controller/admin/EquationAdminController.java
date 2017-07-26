package com.sein.controller.admin;

import com.sein.service.EquationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class EquationAdminController {

    @Autowired
    private EquationService equationService;

    @RequestMapping("/equationManage")
    public String equationManage(Model model){
        List<String> equationList = equationService.getEquationList();
        model.addAttribute("equationList",equationList);
        return "background/equationManage";
    }


}
