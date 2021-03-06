package com.sein.service.utils;

import com.sein.pojo.dto.PollutantChartItem;
import com.sein.pojo.dto.PollutantItem;
import com.sein.pojo.po.DisplayConfig;
import com.sein.pojo.po.Pollutant;
import com.sein.utils.DateUtil;
import com.sein.utils.DecimalUtil;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

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
     * 获取单个设备单条浓度
     *
     * @param displayConfig
     * @param pollutant
     * @return
     */
    public static List<PollutantItem> getPollutantItemList(DisplayConfig displayConfig, Pollutant pollutant) {

        List<PollutantItem> itemList = new ArrayList<>();
        //添加时间
        itemList.add(new PollutantItem("time", DateUtil.formatStrToStr(pollutant.getTime(), "yyyy-MM-dd HH:mm:ss")));
        if(displayConfig.getPm25()==1){
            if(pollutant.getPm25()==null){
                itemList.add(new PollutantItem("PM25",null));
            }else{
                if(pollutant.getPm25()<0){
                    itemList.add(new PollutantItem("PM25",null));
                }else{
                    itemList.add(new PollutantItem("PM25",pollutant.getPm25().toString()));
                }
            }
        }
        if(displayConfig.getPm10()==1){
            if(pollutant.getPm10()==null){
                itemList.add(new PollutantItem("PM10",null));
            }else{
                if(pollutant.getPm10()<0){
                    itemList.add(new PollutantItem("PM10",pollutant.getPm10().toString()));
                }else{
                    itemList.add(new PollutantItem("PM10",pollutant.getPm10().toString()));
                }
            }
        }
        if(displayConfig.getPm1()==1){
            if(pollutant.getPm1()==null){
                itemList.add(new PollutantItem("PM1",null));
            }else{
                if(pollutant.getPm1()<0){
                    itemList.add(new PollutantItem("PM1",null));
                }else{
                    itemList.add(new PollutantItem("PM1",pollutant.getPm1().toString()));
                }
            }
        }
        if(displayConfig.getCo()==1){
            if(pollutant.getCo()==null){
                itemList.add(new PollutantItem("CO",null));
            }else{
                if(pollutant.getCo()<0){
                    itemList.add(new PollutantItem("CO",null));
                }else{
                    itemList.add(new PollutantItem("CO",pollutant.getCo().toString()));
                }
            }
        }
        if(displayConfig.getCo2()==1){
            if(pollutant.getCo2()==null){
                itemList.add(new PollutantItem("CO2",null));
            }else{
                if(pollutant.getCo2()<0){
                    itemList.add(new PollutantItem("CO2",null));
                }else{
                    itemList.add(new PollutantItem("CO2",pollutant.getCo2().toString()));
                }
            }
        }
        if(displayConfig.getNo()==1){
            if(pollutant.getNo()==null){
                itemList.add(new PollutantItem("NO",null));
            }else{
                if(pollutant.getNo()<0){
                    itemList.add(new PollutantItem("NO",null));
                }else{
                    itemList.add(new PollutantItem("NO",pollutant.getNo().toString()));
                }
            }
        }
        if(displayConfig.getNo2()==1){
            if(pollutant.getNo2()==null){
                itemList.add(new PollutantItem("NO2",null));
            }else {
                if(pollutant.getNo2()<0){
                    itemList.add(new PollutantItem("NO2",null));
                }else{
                    itemList.add(new PollutantItem("NO2",pollutant.getNo2().toString()));
                }
            }
        }

        if(displayConfig.getSo2()==1){
            if(pollutant.getSo2()==null){
                itemList.add(new PollutantItem("SO2",null));
            }else{
                if(pollutant.getSo2()<0){
                    itemList.add(new PollutantItem("SO2",null));
                }else{
                    itemList.add(new PollutantItem("SO2",pollutant.getSo2().toString()));
                }
            }
        }
        if(displayConfig.getO3()==1){
            if(pollutant.getO3()==null){
                itemList.add(new PollutantItem("O3",null));
            }else{
                if(pollutant.getO3()<0){
                    itemList.add(new PollutantItem("O3",null));
                }else{
                    itemList.add(new PollutantItem("O3",pollutant.getO3().toString()));
                }
            }
        }
        if(displayConfig.getCl2()==1){
            if(pollutant.getCl2()==null){
                itemList.add(new PollutantItem("CL2",null));
            }else{
                if(pollutant.getCl2()<0){
                    itemList.add(new PollutantItem("CL2",null));
                }else{
                    itemList.add(new PollutantItem("CL2",pollutant.getCl2().toString()));
                }
            }
        }
        if(displayConfig.getVoc()==1){
            if(pollutant.getVoc()==null){
                itemList.add(new PollutantItem("VOC",null));
            }else{
                if(pollutant.getVoc()<0){
                    itemList.add(new PollutantItem("VOC",null));
                }else{
                    itemList.add(new PollutantItem("VOC",pollutant.getVoc().toString()));
                }
            }
        }
        if(displayConfig.getPress()==1){
            if(pollutant.getPress()==null){
                itemList.add(new PollutantItem("Press",null));
            }else{
                if(pollutant.getPress()<0){
                    itemList.add(new PollutantItem("Press",null));
                }else{
                    itemList.add(new PollutantItem("Press",pollutant.getPress().toString()));
                }
            }
        }
        if(displayConfig.getTemp()==1){
            if(pollutant.getTemp()==null){
                itemList.add(new PollutantItem("Temp",null));
            }else {
                if(pollutant.getTemp()<0){
                    itemList.add(new PollutantItem("Temp",null));
                }else {
                    itemList.add(new PollutantItem("Temp",pollutant.getTemp().toString()));
                }
            }
        }
        if(displayConfig.getHumi()==1){
            if(pollutant.getHumi()==null){
                itemList.add(new PollutantItem("Humi",null));
            }else{
                if(pollutant.getHumi()<0){
                    itemList.add(new PollutantItem("Humi",null));
                }else{
                    itemList.add(new PollutantItem("Humi",pollutant.getHumi().toString()));
                }
            }
        }

        return itemList;

    }

    /**
     * 获取单个折线图单种类型数据
     * @param pollutantType
     * @param pollutantList
     * @return
     */
    public static List<PollutantChartItem> getPollutantChartList(String pollutantType,List<Pollutant> pollutantList,TreeSet<String> xaisMaxSet) {
        List<PollutantChartItem> itemList = new ArrayList<>();

        //遍历浓度表，封装成前台折线图需要的time-value列表
        for (Pollutant pollutant : pollutantList) {
            //如果时间为空则
            if(pollutant==null){
                continue;
            }
            if(StringUtils.isEmpty(pollutant.getTime())){
                continue;
            }
            PollutantChartItem item = new PollutantChartItem();

            //封装time
            item.setTime(DateUtil.formatStrToStr(pollutant.getTime(), "yyyy-MM-dd HH:mm:ss"));
            //将所有毫秒时间添加进SET里,去重
            if(xaisMaxSet!=null){
                xaisMaxSet.add(item.getTime());
            }
            switch (pollutantType) {
                case "PM25":
                    item.setValue(pollutant.getPm25()==null?null:pollutant.getPm25()<0?null:pollutant.getPm25());
                    break;
                case "PM10":
                    item.setValue(pollutant.getPm10()==null?null:pollutant.getPm10()<0?null:pollutant.getPm10());
                    break;
                case "PM1":
                    item.setValue(pollutant.getPm1()==null?null:pollutant.getPm1()<0?null:pollutant.getPm1());
                    break;
                case "CO":
                    item.setValue(pollutant.getCo()==null?null:pollutant.getCo()<0?null:pollutant.getCo());
                    break;
                case "CO2":
                    item.setValue(pollutant.getCo2()==null?null:pollutant.getCo2()<0?null:pollutant.getCo2());
                    break;
                case "NO":
                    item.setValue(pollutant.getNo()==null?null:pollutant.getNo()<0?null:pollutant.getNo());
                    break;
                case "NO2":
                    item.setValue(pollutant.getNo2()==null?null:pollutant.getNo2()<0?null:pollutant.getNo2());
                    break;
                case "SO2":
                    item.setValue(pollutant.getSo2()==null?null:pollutant.getSo2()<0?null:pollutant.getSo2());
                    break;
                case "CL2":
                    item.setValue(pollutant.getCl2()==null?null:pollutant.getCl2()<0?null:pollutant.getCl2());
                    break;
                case "O3":
                    item.setValue(pollutant.getO3()==null?null:pollutant.getO3()<0?null:pollutant.getO3());
                    break;
                case "VOC":
                    item.setValue(pollutant.getVoc()==null?null:pollutant.getVoc()<0?null:pollutant.getVoc());
                    break;
                case "Press":
                    item.setValue(pollutant.getPress()==null?null:pollutant.getPress()<0?null:pollutant.getPress());
                    break;
                case "Humi":
                    item.setValue(pollutant.getHumi()==null?null:pollutant.getHumi()<0?null:pollutant.getHumi());
                    break;
                case "Temp":
                    item.setValue(pollutant.getTemp()==null?null:pollutant.getTemp()<0?null:pollutant.getTemp());
                    break;
            }
            itemList.add(item);
        }
        return itemList;
    }


    /**
     * 进行单位转换
     * @param pollutantList
     */
    public static void transformUnit(List<Pollutant> pollutantList){
        for(Pollutant pollutant:pollutantList){
            if(pollutant.getTemp()==null){
                continue;
            }
            double Temp=pollutant.getTemp();
            if(pollutant.getNo()!=null){
                pollutant.setNo(DecimalUtil.formatDecimal(pollutant.getNo()*28*12.187/(273.15+Temp),"#.##"));
            }
            if(pollutant.getNo2()!=null){
                pollutant.setNo2(DecimalUtil.formatDecimal(pollutant.getNo2()*46*12.187/(273.15+Temp),"#.##"));
            }
            if(pollutant.getO3()!=null){
                pollutant.setO3(DecimalUtil.formatDecimal(pollutant.getO3()*48*12.187/(273.15+Temp),"#.##"));
            }
            if(pollutant.getCo()!=null){
                pollutant.setCo(DecimalUtil.formatDecimal(pollutant.getCo()*28*12.187/(273.15+Temp),"#.##"));
            }
            if(pollutant.getCo2()!=null){
                pollutant.setCo2(DecimalUtil.formatDecimal(pollutant.getCo2()*44*12.187/(273.15+Temp),"#.##"));
            }
            if(pollutant.getSo2()!=null){
                pollutant.setSo2(DecimalUtil.formatDecimal(pollutant.getSo2()*64*12.187/(273.15+Temp),"#.##"));
            }
            if(pollutant.getVoc()!=null){
                pollutant.setVoc(DecimalUtil.formatDecimal(pollutant.getVoc()*56.1*12.187/(273.15+Temp),"#.##"));
            }
        }
    }

}
