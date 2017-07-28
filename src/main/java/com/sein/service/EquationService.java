package com.sein.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sein.dao.sensor.EquationDAO;
import com.sein.pojo.dto.PageResult;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class EquationService {

    @Autowired
    private EquationDAO equationDAO;

    /**
     * 截取表的前半部分做为项目名，获取所有的项目名。
     *
     * @return
     */
    public List<String> getProjectList() {
        List<String> projectList = new ArrayList<>();

        //从数据库获取所有表名
        List<String> tableNameList = equationDAO.getTableNameList();
        //遍历表名
        for (String tableName : tableNameList) {
            String[] strings = tableName.split("_");
            if (strings.length > 1) {
                String postfix = strings[1];
                //获取后缀是equation的equation
                if ("equation".equals(postfix)) {
                    projectList.add(strings[0]);
                }
            }

        }
        return projectList;
    }

    /**
     * 获取公式参数列表，
     *
     * @param pageNum
     * @param pageSize
     * @param project  项目名
     * @return
     */
    public PageResult<Equation> listEquation(Integer pageNum, Integer pageSize, String project) {
        PageResult<Equation> pageResult = new PageResult<>();
        //切入分页sql
        Page<Equation> page = PageHelper.startPage(pageNum, pageSize);

        HashMap<String, Object> param = new HashMap<>();
        param.put("projectTable", project.trim() + "_equation");
        List<Equation> equationList = equationDAO.listEquation(param);
        //从表中sensor_basic中获取type
        for (Equation equation : equationList) {
            String type = equationDAO.getPollutantType(equation.getCode());
            equation.setType(type);
        }
        //获取总记录数
        long total = page.getTotal();
        //封装参数
        pageResult.setRows(equationList);
        pageResult.setTotal(total);
        return pageResult;
    }

    /**
     * 更新参数表
     *
     * @param equation
     * @return
     */
    public Result updateEquation(Equation equation) {
        //加上表格后缀
        equation.setProject(equation.getProject() + "_equation");
        equationDAO.updateEquation(equation);
        return Result.isOK();
    }

    /**
     * 删除一条参数信息
     *
     * @param item
     * @param project
     * @return
     */
    public Result deleteEquation(Integer item, String project) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("item", item);
        param.put("projectTable", project + "_equation");
        equationDAO.deleteEquation(param);
        return Result.isOK();
    }

    public Result addEquation(Equation equation) {
        equation.setProject(equation.getProject() + "_equation");
        equationDAO.addEquation(equation);
        return Result.isOK();
    }
}
