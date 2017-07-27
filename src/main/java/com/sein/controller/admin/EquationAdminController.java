package com.sein.controller.admin;

import com.sein.pojo.dto.PageResult;
import com.sein.pojo.po.Equation;
import com.sein.service.EquationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class EquationAdminController {

    @Autowired
    private EquationService equationService;

    @RequestMapping("/equationManage")
    public String equationManage(Model model){
        List<String> projectList = equationService.getProjectList();
        model.addAttribute("projectList",projectList);
        return "background/equationManage";
    }

    @GetMapping("/equation/list/{page}")
    @ResponseBody
    public PageResult<Equation> getEquationList(@PathVariable Integer page, Integer pageSize,String project) {
        //获取分页列表
        PageResult<Equation> pageResult = equationService.listEquation(page, pageSize,project);
        return pageResult;
    }

    @PutMapping("/equation")
    public String updateEquation(Equation equation){
        equationService.updateEquation(equation);
        return "redirect:/equationManage";
    }


}
