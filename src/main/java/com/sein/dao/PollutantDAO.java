package com.sein.dao;

import com.sein.pojo.po.Pollutant;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/7/12.
 */
public interface PollutantDAO {

    /**
     * 获取浓度列表
     *
     * @param param
     * @return
     */
    List<Pollutant> listPollutant(HashMap<String, Object> param);

    /**
     * 获取单个浓度信息
     *
     * @param param
     * @return
     */
    Pollutant getPollutant(HashMap<String, Object> param);

    /**
     * 获取总数目
     *
     * @param param
     * @return
     */
    Integer getPollutantCount(HashMap<String, Object> param);

    /**
     * 获取设备最新GPS信息
     *
     * @param pollutantTable
     * @return
     */
    Pollutant getDeviceNewestGPS(@Param("pollutantTable") String pollutantTable);

    /**
     * 查询是否有GPS列
     *
     * @param pollutantTable
     * @return
     */
    Integer isExistGPSColumn(@Param("pollutantTable") String pollutantTable);

    /**
     * 查询是否存在浓度表
     * @param pollutantTable
     * @return
     */
    Integer isExistPollutantTable(@Param("pollutantTable") String pollutantTable);

    /**
     * 获取浓度表的列名列表
     * @param pollutantTable
     * @return
     */
    List<String> getColumnNameList(@Param("pollutantTable")String pollutantTable);

    /**
     * 获取浓度表表名列表
     * @param pollutantTable
     * @return
     */
    List<String> getTableNameList(@Param("pollutantTable")String pollutantTable);

}
