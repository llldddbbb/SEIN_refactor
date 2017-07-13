package com.sein.dao;

import com.sein.pojo.po.Pollutant;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/7/12.
 */
public interface PollutantDAO {

    /**
     * 获取浓度列表
     * @param param
     * @return
     */
    List<Pollutant> listPollutant(HashMap<String,Object> param);

    /**
     * 获取单个浓度信息
     * @param param
     * @return
     */
    Pollutant getPollutant(HashMap<String,Object> param);

    /**
     * 获取总数目
     * @param param
     * @return
     */
    Integer getPollutantCount(HashMap<String,Object> param);

}
