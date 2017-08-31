package com.sein.service.utils;

import com.sein.pojo.po.Pollutant;
import com.sein.utils.DecimalUtil;
import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldb on 2017/4/1.
 */
public class ExcelUtil {

    /**
     * 获取表格头部
     * @param pollutantType
     * @param unit
     * @return
     */
    public static ArrayList<String> getExcelHeader(String pollutantType,String unit){
        ArrayList<String> excelHeader=new ArrayList<>();
        String[] pollutantTypeStrArr=pollutantType.split(",");
        for(String pollutantTypeStr:pollutantTypeStrArr){
            switch (pollutantTypeStr){
                case "DateTime":
                    excelHeader.add("监测时间");
                    break;
                case "PM25":
                    excelHeader.add("PM₂.₅(µg/m³)");
                    break;
                case "PM10":
                    excelHeader.add("PM₁₀(µg/m³)");
                    break;
                case "PM1":
                    excelHeader.add("PM₁(µg/m³)");
                    break;
                case "CO":
                    if ("umgm".equals(unit)) {
                        excelHeader.add("CO(µg/m³)");
                    }else{
                        excelHeader.add("CO(ppm)");
                    }
                    break;
                case "CO2":
                    if ("umgm".equals(unit)) {
                        excelHeader.add("CO₂(µg/m³)");
                    }else{
                        excelHeader.add("CO₂(ppm)");
                    }
                    break;
                case "NO":
                    if ("umgm".equals(unit)) {
                        excelHeader.add("NO(µg/m³)");
                    }else{
                        excelHeader.add("NO(ppb)");
                    }
                    break;
                case "NO2":
                    if ("umgm".equals(unit)) {
                        excelHeader.add("NO₂(µg/m³)");
                    }else{
                        excelHeader.add("NO₂(ppb)");
                    }
                    break;
                case "SO":
                    if ("umgm".equals(unit)) {
                        excelHeader.add("SO(µg/m³)");
                    }else{
                        excelHeader.add("SO(ppb)");
                    }
                    break;
                case "SO2":
                    if ("umgm".equals(unit)) {
                        excelHeader.add("SO₂(µg/m³)");
                    }else{
                        excelHeader.add("SO₂(ppb)");
                    }
                    break;
                case "CL2":
                    if ("umgm".equals(unit)) {
                        excelHeader.add("CL₂(µg/m³)");
                    }else{
                        excelHeader.add("CL₂(ppb)");
                    }
                    break;
                case "O3":
                    if ("umgm".equals(unit)) {
                        excelHeader.add("O₃(µg/m³)");
                    }else{
                        excelHeader.add("O₃(ppb)");
                    }
                    break;
                case "VOC":
                    if ("umgm".equals(unit)) {
                        excelHeader.add("VOC(µg/m³)");
                    }else{
                        excelHeader.add("VOC(ppb)");
                    }
                    break;
                case "Temp":
                    excelHeader.add("温度(℃)");
                    break;
                case "Humi":
                    excelHeader.add("湿度(%)");
                    break;
                case "Longitude":
                    excelHeader.add("经度");
                    break;
                case "Latitude":
                    excelHeader.add("纬度");
                    break;
                case "Press":
                    excelHeader.add("压力(Pa)");
                    break;
            }
        }
        return excelHeader;
    }

    /**
     * 填充excel数据
     * @param pollutantList
     * @param excelHeader
     * @param wb
     */
    public static void fullExcelData(List<Pollutant> pollutantList,List<String> excelHeader,Workbook wb){
        Sheet sheet = wb.createSheet("data");

        int rowIndex=0;
        CellStyle style=wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        Row row = sheet.createRow(rowIndex++);
        for(int i=0;i<excelHeader.size();i++){
            Cell cell=row.createCell(i);
            cell.setCellValue(excelHeader.get(i));
            cell.setCellStyle(style);
            sheet.setColumnWidth(i, 12 * 256);
        }
        sheet.setColumnWidth(0, 22 * 256);

        for(int i=0;i<pollutantList.size();i++){
            Pollutant pollutant=pollutantList.get(i);
            row = sheet.createRow(rowIndex++);
            for(int j=0;j<excelHeader.size();j++){
                Cell cell=row.createCell(j);
                cell.setCellStyle(style);
                switch (excelHeader.get(j)){
                    case "监测时间":
                        cell.setCellValue(pollutant.getTime());
                        break;
                    case "PM₂.₅(µg/m³)":
                        if(pollutant.getPm25()==null){
                            cell.setCellValue("");
                        }else{

                                cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getPm25(), "#.#"));

                        }
                        break;
                    case "PM₁₀(µg/m³)":
                        if(pollutant.getPm10()==null){
                            cell.setCellValue("");
                        }else{

                                cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getPm10(), "#.#"));

                        }
                        break;
                    case "PM₁(µg/m³)":
                        if(pollutant.getPm1()==null){
                            cell.setCellValue("");
                        }else{

                                cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getPm1(), "#.#"));

                        }
                        break;
                    case "CO(ppm)":
                    case "CO(µg/m³)":
                        if(pollutant.getCo()==null){
                            cell.setCellValue("");
                        }else{

                                cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getCo(), "#.###"));

                        }
                        break;
                    case "CO₂(ppm)":
                    case "CO₂(µg/m³)":
                        if(pollutant.getCo2()==null){
                            cell.setCellValue("");
                        }else{

                                cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getCo2(), "#.###"));

                        }
                        break;
                    case "NO(ppb)":
                    case "NO(µg/m³)":
                        if(pollutant.getNo()==null){
                            cell.setCellValue("");
                        }else{

                                cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getNo(), "#.#"));

                        }
                        break;
                    case "NO₂(ppb)":
                    case "NO₂(µg/m³)":
                        if(pollutant.getNo2()==null){
                            cell.setCellValue("");
                        }else{

                                cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getNo2(), "#.#"));

                        }
                        break;
                    case "SO₂(ppb)":
                    case "SO₂(µg/m³)":
                        if(pollutant.getSo2()==null){
                            cell.setCellValue("");
                        }else{

                                cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getSo2(), "#.#"));

                        }
                        break;
                    case "O₃(ppb)":
                    case "O₃(µg/m³)":
                        if(pollutant.getO3()==null){
                            cell.setCellValue("");
                        }else{

                                cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getO3(), "#.#"));

                        }
                        break;
                    case "CL2(ppb)":
                    case "CL₂(µg/m³)":
                        if(pollutant.getCl2()==null){
                            cell.setCellValue("");
                        }else{

                                cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getCl2(), "#.#"));

                        }
                        break;
                    case "VOC(ppb)":
                    case "VOC(µg/m³)":
                        if(pollutant.getVoc()==null){
                            cell.setCellValue("");
                        }else{

                                cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getVoc(), "#.#"));

                        }
                        break;
                    case "温度(℃)":
                        if(pollutant.getTemp()==null){
                            cell.setCellValue("");
                        }else{

                                cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getTemp(), "#.#"));

                        }
                        break;
                    case "湿度(%)":
                        if(pollutant.getHumi()==null){
                            cell.setCellValue("");
                        }else{

                                cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getHumi(), "#.#"));

                        }
                        break;
                    case "经度":
                        if(pollutant.getLongitude()==null){
                            cell.setCellValue("");
                        }else{
                            cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getLongitude(), "#.####"));
                        }
                        break;
                    case "纬度":
                        if(pollutant.getLatitude()==null){
                            cell.setCellValue("");
                        }else{
                            cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getLatitude(), "#.####"));
                        }
                        break;
                    case "压力(Pa)":
                        if(pollutant.getPress()==null){
                            cell.setCellValue("");
                        }else{
                            cell.setCellValue(DecimalUtil.formatDecimal(pollutant.getPress(), "#.#"));
                        }
                        break;
                }
            }
        }
    }




}
