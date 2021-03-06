package com.sein.controller.admin;

import com.sein.pojo.dto.PageResult;
import com.sein.pojo.dto.Result;
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
    @ResponseBody
    public Result updateEquation(Equation equation){
        equationService.updateEquation(equation);
        return Result.isOK();
    }

    @DeleteMapping("/equation/{item}/{project}")
    @ResponseBody
    public Result deleteEquation(@PathVariable Integer item,@PathVariable String project){
        return equationService.deleteEquation(item,project);
    }

    @RequestMapping("/addEquation")
    public String addEquationPage(Model model) {
        List<String> projectList = equationService.getProjectList();
        model.addAttribute("projectList",projectList);
        return "background/addEquation";
    }

    @PostMapping("/equation")
    @ResponseBody
    public Result addEquation(Equation equation){
        return equationService.addEquation(equation);
    }

    @PostMapping("/createProject")
    @ResponseBody
    public Result createProject(String project){
        return equationService.createProject(project);
    }


}
