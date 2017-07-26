package com.sein.service;

import com.sein.dao.sensor.EquationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquationService {

    @Autowired
    private EquationDAO equationDAO;

    public List<String> getEquationList(){
        List<String> equationList=new ArrayList<>();

        //从数据库获取所有表名
        List<String> tableNameList = equationDAO.getTableNameList();
        //遍历表名
        for (String tableName : tableNameList) {
            String[] strings = tableName.split("_");
            if(strings.length>1){
                String postfix=strings[1];
                //获取后缀是equation的equation
                if("equation".equals(postfix)){
                    equationList.add(strings[0]);
                }
            }

        }
        return equationList;
    }

}
