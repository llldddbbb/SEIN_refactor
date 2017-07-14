package com.sein.service.utils;

import com.sein.pojo.po.Pollutant;
import com.sein.utils.DateUtil;
import com.sein.utils.DecimalUtil;

import java.util.List;

/**
 * Created by ldb on 2017/3/30.
 */
public class TableUtil {


    /**
     * 获取网页表格头部
     *
     * @param pollutantType
     * @param unit
     * @return
     */
    public static String getTableHeader(String pollutantType, String unit) {
        StringBuilder tableHeader = new StringBuilder();
        String[] pollutantTypeStrArr = pollutantType.split(",");
        tableHeader.append("<tr>");
        for (String pollutantTypeStr : pollutantTypeStrArr) {
            switch (pollutantTypeStr) {
                case "DateTime":
                    tableHeader.append("<th>监测时间</th>");
                    break;
                case "PM25":
                    tableHeader.append("<th>PM<sub>2.5</sub>(µg/m³)</th>");
                    break;
                case "PM10":
                    tableHeader.append("<th>PM<sub>10</sub>(µg/m³)</th>");
                    break;
                case "PM1":
                    tableHeader.append("<th>PM<sub>1</sub>(µg/m³)</th>");
                    break;
                case "CO":
                    if ("umgm".equals(unit)) {
                        tableHeader.append("<th>CO(µg/m³)</th>");
                    } else {
                        tableHeader.append("<th>CO(ppm)</th>");
                    }
                    break;
                case "CO2":
                    if ("umgm".equals(unit)) {
                        tableHeader.append("<th>CO<sub>2</sub>(µg/m³)</th>");
                    } else {
                        tableHeader.append("<th>CO<sub>2</sub>(ppm)</th>");
                    }
                    break;
                case "NO":
                    if ("umgm".equals(unit)) {
                        tableHeader.append("<th>NO(µg/m³)</th>");
                    } else {
                        tableHeader.append("<th>NO(ppb)</th>");
                    }
                    break;
                case "NO2":
                    if ("umgm".equals(unit)) {
                        tableHeader.append("<th>NO<sub>2</sub>(µg/m³)</th>");
                    } else {
                        tableHeader.append("<th>NO<sub>2</sub>(ppb)</th>");
                    }
                    break;
                case "SO":
                    if ("umgm".equals(unit)) {
                        tableHeader.append("<th>SO(µg/m³)</th>");
                    } else {
                        tableHeader.append("<th>SO(ppb)</th>");
                    }
                    break;
                case "SO2":
                    if ("umgm".equals(unit)) {
                        tableHeader.append("<th>SO<sub>2</sub>(µg/m³)</th>");
                    } else {
                        tableHeader.append("<th>SO<sub>2</sub>(ppb)</th>");
                    }
                    break;
                case "CL2":
                    if ("umgm".equals(unit)) {
                        tableHeader.append("<th>Cl<sub>2</sub>(µg/m³)</th>");
                    } else {
                        tableHeader.append("<th>Cl<sub>2</sub>(ppb)</th>");
                    }
                    break;
                case "O3":
                    if ("umgm".equals(unit)) {
                        tableHeader.append("<th>O<sub>3</sub>(µg/m³)</th>");
                    } else {
                        tableHeader.append("<th>O<sub>3</sub>(ppb)</th>");
                    }
                    break;
                case "VOC":
                    tableHeader.append("<th>VOC(ppb)</th>");
                    break;
                case "Humi":
                    tableHeader.append("<th>湿度(%)</th>");
                    break;
                case "Temp":
                    tableHeader.append("<th>温度(℃)</th>");
                    break;
                case "Longitude":
                    tableHeader.append("<th>&nbsp;&nbsp经度&nbsp;&nbsp</th>");
                    break;
                case "Latitude":
                    tableHeader.append("<th>&nbsp;&nbsp纬度&nbsp;&nbsp</th>");
                    break;
                case "Press":
                    tableHeader.append("<th>压力(Pa)</th>");
                    break;
            }
        }
        tableHeader.append("</tr>");
        return tableHeader.toString();
    }


    /**
     * 获取网页表格内容
     *
     * @param pollutantType
     * @param pollutantList
     * @return
     */
    public static String getTableBody(String pollutantType, List<Pollutant> pollutantList) {
        StringBuilder tableBody = new StringBuilder();
        String[] pollutantTypeStrArr = pollutantType.split(",");
        for (int i = 0; i < pollutantList.size(); i++) {
            Pollutant pollutant = pollutantList.get(i);
            tableBody.append("<tr>");
            for (String pollutantTypeStr : pollutantTypeStrArr) {
                switch (pollutantTypeStr) {
                    case "DateTime":
                        tableBody.append("<td>" + DateUtil.formatStrToStr(pollutant.getTime(),"yyyy-MM-dd HH:mm:ss") + "</td>");
                        break;
                    case "PM25":
                        tableBody.append("<td>" + (pollutant.getPm25() == null ? null : pollutant.getPm25() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getPm25(), "#.#")) + "</td>");
                        break;
                    case "PM10":
                        tableBody.append("<td>" + (pollutant.getPm10() == null ? null : pollutant.getPm10() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getPm10(), "#.#")) + "</td>");
                        break;
                    case "PM1":
                        tableBody.append("<td>" + (pollutant.getPm1() == null ? null : pollutant.getPm1() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getPm1(), "#.#")) + "</td>");
                        break;
                    case "CO":
                        tableBody.append("<td>" + (pollutant.getCo() == null ? null : pollutant.getCo() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getCo(), "#.###")) + "</td>");
                        break;
                    case "CO2":
                        tableBody.append("<td>" + (pollutant.getCo2() == null ? null : pollutant.getCo2() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getCo2(), "#.###")) + "</td>");
                        break;
                    case "NO":
                        tableBody.append("<td>" + (pollutant.getNo() == null ? null : pollutant.getNo() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getNo(), "#.#")) + "</td>");
                        break;
                    case "NO2":
                        tableBody.append("<td>" + (pollutant.getNo2() == null ? null : pollutant.getNo2() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getNo2(), "#.#")) + "</td>");
                        break;
                    case "SO":
                        tableBody.append("<td>" + (pollutant.getSo() == null ? null : pollutant.getSo() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getSo(), "#.#")) + "</td>");
                        break;
                    case "SO2":
                        tableBody.append("<td>" + (pollutant.getSo2() == null ? null : pollutant.getSo2() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getSo2(), "#.#")) + "</td>");
                        break;
                    case "CL2":
                        tableBody.append("<td>" + (pollutant.getCl2() == null ? null : pollutant.getCl2() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getCl2(), "#.#")) + "</td>");
                        break;
                    case "O3":
                        tableBody.append("<td>" + (pollutant.getO3() == null ? null : pollutant.getO3() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getO3(), "#.#")) + "</td>");
                        break;
                    case "VOC":
                        tableBody.append("<td>" + (pollutant.getVoc() == null ? null : pollutant.getVoc() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getVoc(), "#.#")) + "</td>");
                        break;
                    case "Humi":
                        tableBody.append("<td>" + (pollutant.getHumi() == null ? null : pollutant.getHumi() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getHumi(), "#.#")) + "</td>");
                        break;
                    case "Temp":
                        tableBody.append("<td>" + (pollutant.getTemp() == null ? null : pollutant.getTemp() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getTemp(), "#.#")) + "</td>");
                        break;
                    case "Longitude":
                        tableBody.append("<td>" + (pollutant.getLongitude() == null ? null : DecimalUtil.formatDecimal(pollutant.getLongitude(), "#.####")) + "</td>");
                        break;
                    case "Latitude":
                        tableBody.append("<td>" + (pollutant.getLatitude() == null ? null : DecimalUtil.formatDecimal(pollutant.getLatitude(), "#.####")) + "</td>");
                        break;
                    case "Press":
                        tableBody.append("<td>" + pollutant.getPress() + "</td>");
                        break;
                }
            }
            tableBody.append("</tr>");
        }
        return tableBody.toString();
    }
}
