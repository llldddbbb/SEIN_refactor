package com.sein.dao.sensor;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EquationDAO {

    List<String> getTableNameList();
}