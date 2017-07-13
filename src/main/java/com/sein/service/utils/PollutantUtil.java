package com.sein.service.utils;

import com.sein.pojo.dto.PollutantItem;
import com.sein.pojo.po.DisplayConfig;
import com.sein.pojo.po.Pollutant;
import com.sein.utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldb on 2017/7/13.
 * 浓度工具类:封装污染物等
 */
public class PollutantUtil {

    /**
     * 获取最新的表格后缀
     *
     * @param displayConfig
     * @return
     */
    public static String getNewestPostfix(DisplayConfig displayConfig) {
        String postfix = "_1min";
        if (displayConfig.getOriginal() == 1) {
            postfix = "_original";
        } else if (displayConfig.getMin1() == 1) {
            postfix = "_1min";
        } else if (displayConfig.getMin10() == 1) {
            postfix = "_10min";
        } else if (displayConfig.getMin15() == 1) {
            postfix = "_15min";
        } else if (displayConfig.getMin30() == 1) {
            postfix = "_30min";
        } else if (displayConfig.getH1() == 1) {
            postfix = "_1h";
        } else if (displayConfig.getD1() == 1) {
            postfix = "_1d";
        }
        return postfix;
    }
    

    /**
     * 封装PollutantItemList
     * @param displayConfig
     * @param pollutant
     * @return
     */
    public static List<PollutantItem> getPollutantItemList(DisplayConfig displayConfig, Pollutant pollutant){
        List<PollutantItem> pollutantItemList=new ArrayList<>();
        //添加时间
        pollutantItemList.add(new PollutantItem("time", DateUtil.formatStrToStr(pollutant.getTime(),"yyyy-MM-dd HH:mm:ss")));
        if(displayConfig.getPm25()==1){
            if(pollutant.getPm25()==null){
                pollutantItemList.add(new PollutantItem("PM25",null));
            }else{
                if(pollutant.getPm25()<0){
                    pollutantItemList.add(new PollutantItem("PM25",null));
                }else{
                    pollutantItemList.add(new PollutantItem("PM25",pollutant.getPm25().toString()));
                }
            }
        }
        if(displayConfig.getPm10()==1){
            if(pollutant.getPm10()==null){
                pollutantItemList.add(new PollutantItem("PM10",null));
            }else{
                if(pollutant.getPm10()<0){
                    pollutantItemList.add(new PollutantItem("PM10",pollutant.getPm10().toString()));
                }else{
                    pollutantItemList.add(new PollutantItem("PM10",pollutant.getPm10().toString()));
                }
            }
        }
        if(displayConfig.getPm1()==1){
            if(pollutant.getPm1()==null){
                pollutantItemList.add(new PollutantItem("PM1",null));
            }else{
                if(pollutant.getPm1()<0){
                    pollutantItemList.add(new PollutantItem("PM1",null));
                }else{
                    pollutantItemList.add(new PollutantItem("PM1",pollutant.getPm1().toString()));
                }
            }
        }
        if(displayConfig.getCo()==1){
            if(pollutant.getCo()==null){
                pollutantItemList.add(new PollutantItem("CO",null));
            }else{
                if(pollutant.getCo()<0){
                    pollutantItemList.add(new PollutantItem("CO",null));
                }else{
                    pollutantItemList.add(new PollutantItem("CO",pollutant.getCo().toString()));
                }
            }
        }
        if(displayConfig.getCo2()==1){
            if(pollutant.getCo2()==null){
                pollutantItemList.add(new PollutantItem("CO2",null));
            }else{
                if(pollutant.getCo2()<0){
                    pollutantItemList.add(new PollutantItem("CO2",null));
                }else{
                    pollutantItemList.add(new PollutantItem("CO2",pollutant.getCo2().toString()));
                }
            }
        }
        if(displayConfig.getNo()==1){
            if(pollutant.getNo()==null){
                pollutantItemList.add(new PollutantItem("NO",null));
            }else{
                if(pollutant.getNo()<0){
                    pollutantItemList.add(new PollutantItem("NO",null));
                }else{
                    pollutantItemList.add(new PollutantItem("NO",pollutant.getNo().toString()));
                }
            }
        }
        if(displayConfig.getNo2()==1){
            if(pollutant.getNo2()==null){
                pollutantItemList.add(new PollutantItem("NO2",null));
            }else {
                if(pollutant.getNo2()<0){
                    pollutantItemList.add(new PollutantItem("NO2",null));
                }else{
                    pollutantItemList.add(new PollutantItem("NO2",pollutant.getNo2().toString()));
                }
            }
        }
        if(displayConfig.getSo()==1){
            if(pollutant.getSo()==null){
                pollutantItemList.add(new PollutantItem("SO",null));
            }else {
                if(pollutant.getSo()<0){
                    pollutantItemList.add(new PollutantItem("SO",null));
                }else{
                    pollutantItemList.add(new PollutantItem("SO",pollutant.getSo().toString()));
                }
            }
        }
        if(displayConfig.getSo2()==1){
            if(pollutant.getSo2()==null){
                pollutantItemList.add(new PollutantItem("SO2",null));
            }else{
                if(pollutant.getSo2()<0){
                    pollutantItemList.add(new PollutantItem("SO2",null));
                }else{
                    pollutantItemList.add(new PollutantItem("SO2",pollutant.getSo2().toString()));
                }
            }
        }
        if(displayConfig.getO3()==1){
            if(pollutant.getO3()==null){
                pollutantItemList.add(new PollutantItem("O3",null));
            }else{
                if(pollutant.getO3()<0){
                    pollutantItemList.add(new PollutantItem("O3",null));
                }else{
                    pollutantItemList.add(new PollutantItem("O3",pollutant.getO3().toString()));
                }
            }
        }
        if(displayConfig.getCl2()==1){
            if(pollutant.getCl2()==null){
                pollutantItemList.add(new PollutantItem("CL2",null));
            }else{
                if(pollutant.getCl2()<0){
                    pollutantItemList.add(new PollutantItem("CL2",null));
                }else{
                    pollutantItemList.add(new PollutantItem("CL2",pollutant.getCl2().toString()));
                }
            }
        }
        if(displayConfig.getVoc()==1){
            if(pollutant.getVoc()==null){
                pollutantItemList.add(new PollutantItem("VOC",null));
            }else{
                if(pollutant.getVoc()<0){
                    pollutantItemList.add(new PollutantItem("VOC",null));
                }else{
                    pollutantItemList.add(new PollutantItem("VOC",pollutant.getVoc().toString()));
                }
            }
        }
        if(displayConfig.getPress()==1){
            if(pollutant.getPress()==null){
                pollutantItemList.add(new PollutantItem("Press",null));
            }else{
                if(pollutant.getPress()<0){
                    pollutantItemList.add(new PollutantItem("Press",null));
                }else{
                    pollutantItemList.add(new PollutantItem("Press",pollutant.getPress().toString()));
                }
            }
        }
        if(displayConfig.getTemp()==1){
            if(pollutant.getTemp()==null){
                pollutantItemList.add(new PollutantItem("Temp",null));
            }else {
                if(pollutant.getTemp()<0){
                    pollutantItemList.add(new PollutantItem("Temp",null));
                }else {
                    pollutantItemList.add(new PollutantItem("Temp",pollutant.getTemp().toString()));
                }
            }
        }
        if(displayConfig.getHumi()==1){
            if(pollutant.getHumi()==null){
                pollutantItemList.add(new PollutantItem("Humi",null));
            }else{
                if(pollutant.getHumi()<0){
                    pollutantItemList.add(new PollutantItem("Humi",null));
                }else{
                    pollutantItemList.add(new PollutantItem("Humi",pollutant.getHumi().toString()));
                }
            }
        }

        return pollutantItemList;

    }
}
