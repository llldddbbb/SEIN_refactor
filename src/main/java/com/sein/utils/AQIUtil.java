package com.sein.utils;

import com.sein.pojo.dto.PollutantItem;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by ldb on 2017/3/29.
 * AQI计算工具类
 */
public class AQIUtil {

    public static TreeMap<Double,Double> PM25TreeMap=new TreeMap<>();
    static{
        PM25TreeMap.put(0.0, 0.0);
        PM25TreeMap.put(35.0, 50.0);
        PM25TreeMap.put(75.0, 100.0);
        PM25TreeMap.put(115.0, 150.0);
        PM25TreeMap.put(150.0, 200.0);
        PM25TreeMap.put(250.0, 300.0);
        PM25TreeMap.put(350.0, 400.0);
        PM25TreeMap.put(500.0, 500.0);
    }
    public static TreeMap<Double,Double> COTreeMap=new TreeMap<>();
    static{
        COTreeMap.put(0.0,0.0);
        COTreeMap.put(5.0, 50.0);
        COTreeMap.put(10.0, 100.0);
        COTreeMap.put(35.0, 150.0);
        COTreeMap.put(60.0, 200.0);
        COTreeMap.put(90.0,300.0);
        COTreeMap.put(120.0,400.0);
        COTreeMap.put(150.0,500.0);
    }
    public static TreeMap<Double,Double> SO2TreeMap=new TreeMap<>();
    static{
        SO2TreeMap.put(0.0,0.0);
        SO2TreeMap.put(150.0,50.0);
        SO2TreeMap.put(500.0,100.0);
        SO2TreeMap.put(650.0,150.0);
        SO2TreeMap.put(800.0,200.0);
    }
    public static TreeMap<Double,Double> NO2TreeMap=new TreeMap<>();
    static{
        NO2TreeMap.put(0.0,0.0);
        NO2TreeMap.put(100.0,50.0);
        NO2TreeMap.put(200.0,100.0);
        NO2TreeMap.put(700.0,150.0);
        NO2TreeMap.put(1200.0,200.0);
        NO2TreeMap.put(2340.0,300.0);
        NO2TreeMap.put(3090.0,400.0);
        NO2TreeMap.put(3840.0,500.0);
    }
    public static TreeMap<Double,Double> O3TreeMap=new TreeMap<>();
    static{
        O3TreeMap.put(0.0,0.0);
        O3TreeMap.put(160.0,50.0);
        O3TreeMap.put(200.0,100.0);
        O3TreeMap.put(300.0,150.0);
        O3TreeMap.put(400.0,200.0);
        O3TreeMap.put(800.0,300.0);
        O3TreeMap.put(1000.0,400.0);
        O3TreeMap.put(1200.0,500.0);
    }
    public static TreeMap<Double,Double> PM10TreeMap=new TreeMap<>();
    static{
        PM10TreeMap.put(0.0, 0.0);
        PM10TreeMap.put(50.0, 50.0);
        PM10TreeMap.put(150.0, 100.0);
        PM10TreeMap.put(250.0, 150.0);
        PM10TreeMap.put(350.0, 200.0);
        PM10TreeMap.put(420.0, 300.0);
        PM10TreeMap.put(500.0, 400.0);
        PM10TreeMap.put(600.0, 500.0);
    }


    public static Double getAQI(List<PollutantItem> pollutantItemList) throws Exception{
        TreeSet<Double> AQI_result=new TreeSet<>();
        for(PollutantItem pollutantItem:pollutantItemList){
            Double currentIAQIType=null;
            TreeMap<Double,Double> treeMap=null;
            if("PM25".equals(pollutantItem.getType())){
                if(pollutantItem.getValue()==null) continue;
                treeMap=PM25TreeMap;
                currentIAQIType=Double.parseDouble(pollutantItem.getValue());
            }else if("CO".equals(pollutantItem.getType())){
                if(pollutantItem.getValue()==null) continue;
                treeMap=COTreeMap;
                currentIAQIType=Double.parseDouble(pollutantItem.getValue());
            }else if("NO2".equals(pollutantItem.getType())){
                if(pollutantItem.getValue()==null) continue;
                treeMap=NO2TreeMap;
                currentIAQIType=Double.parseDouble(pollutantItem.getValue());
            }else if("SO2".equals(pollutantItem.getType())){
                if(pollutantItem.getValue()==null) continue;
                treeMap=SO2TreeMap;
                currentIAQIType=Double.parseDouble(pollutantItem.getValue());
            }else if("O3".equals(pollutantItem.getType())){
                if(pollutantItem.getValue()==null) continue;
                treeMap=O3TreeMap;
                currentIAQIType=Double.parseDouble(pollutantItem.getValue());
            }else if("PM10".equals(pollutantItem.getType())) {
                if(pollutantItem.getValue()==null) continue;
                treeMap = PM10TreeMap;
                currentIAQIType = Double.parseDouble(pollutantItem.getValue());
            }
            if(currentIAQIType==null){
                continue;
            }
            if(treeMap.lastKey()>currentIAQIType){
                Double IAQIType_high=treeMap.higherKey(currentIAQIType);
                Double IAQIType_low=treeMap.lowerKey(currentIAQIType);
                if(IAQIType_high==null||IAQIType_low==null){
                    continue;
                }
                Double IAQI_high=treeMap.get(IAQIType_high);
                Double IAQI_low=treeMap.get(IAQIType_low);
                Double IAQI_result=(IAQI_high-IAQI_low)/(IAQIType_high-IAQIType_low)*(currentIAQIType-IAQIType_low)+IAQI_low;
                AQI_result.add(IAQI_result);
            }
        }

        return AQI_result.last();
    }


}
