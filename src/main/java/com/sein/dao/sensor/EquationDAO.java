package com.sein.dao.sensor;

import com.sein.pojo.po.Equation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface EquationDAO {

    List<String> getTableNameList();

    List<Equation> listEquation(HashMap<String, Object> param);

    String getPollutantType(@Param("code") String code);

    int updateEquation(Equation equation);
}