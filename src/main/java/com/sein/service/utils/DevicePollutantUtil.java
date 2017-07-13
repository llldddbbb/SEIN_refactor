package com.sein.service.utils;

import com.sein.pojo.dto.DevicePollutant;
import com.sein.utils.DateUtil;

/**
 * Created by ldb on 2017/7/13.
 * 设备浓度工具类
 */
public class DevicePollutantUtil {

    /**
     * 封装离线在线状态
     * @param devicePollutant
     * @param time
     */
    public static void setStatus(DevicePollutant devicePollutant, String time){
        long differ= DateUtil.getMinDifference(time);
        if(differ>90){
            devicePollutant.setStatus(0);
        }else{
            devicePollutant.setStatus(1);
        }
    }
}
