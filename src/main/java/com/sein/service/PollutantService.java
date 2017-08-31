package com.sein.service;

import com.sein.dao.sein.PollutantDAO;
import com.sein.enums.ResultEnum;
import com.sein.pojo.dto.PageBean;
import com.sein.pojo.dto.PollutantTable;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Device;
import com.sein.pojo.po.DisplayConfig;
import com.sein.pojo.po.Pollutant;
import com.sein.service.utils.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/7/13.
 */
@Service
public class PollutantService {

    @Autowired
    private PollutantDAO pollutantDAO;

    @Value("${PAGE_SIZE}")
    private Integer PAGE_SIZE;

    @Value("${POLLUTANT_TYPE_BASE}")
    private String POLLUTANT_TYPE_BASE;

    /**
     * 获取网页表格
     * @param device
     * @param interval
     * @param page
     * @param startTime
     * @param endTime
     * @param unit
     * @param pollutantTypeAndAlerm
     * @return
     */
    public PollutantTable getPollutantTable(Device device, String interval, String page, String startTime, String endTime, String unit, String pollutantTypeAndAlerm) {
        PollutantTable pollutantTable=new PollutantTable();

        //封装参数
        HashMap<String,Object> param=new HashMap<>();
        param.put("startTime",startTime);
        param.put("endTime",endTime);
        //封装表名
        param.put("pollutantTable",device.getPollutantTable()+interval);
        //封装pollutantType和Alerm参数
        this.setPollutantTypeAndAlermParam(pollutantTypeAndAlerm,param);
        //封装分页参数
        if(StringUtils.isEmpty(page)){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page),PAGE_SIZE);
        param.put("start",pageBean.getStart()+"");
        param.put("pageSize",pageBean.getPageSize()+"");


        //倒序显示
        param.put("desc",true);

        //根据参数获取浓度列表
        List<Pollutant> pollutantList=pollutantDAO.listPollutant(param);


        //进行单位换算
        if("umgm".equals(unit)){
            PollutantUtil.transformUnit(pollutantList);
        }

        //获取表格头部
        String tableHeader= TableUtil.getTableHeader((String) param.get("pollutantType"),unit);

        //获取表格内容
        String tableBody=TableUtil.getTableBody((String) param.get("pollutantType"),pollutantList);

        //获取分页
        int totalNum=pollutantDAO.getPollutantCount(param);
        String pageNation= PageUtil.genPageNation(totalNum,pageBean.getPage(),pageBean.getPageSize());

        //设置参数
        pollutantTable.setPageNation(pageNation);
        pollutantTable.setTableHeader(tableHeader);
        pollutantTable.setTableBody(tableBody);
        return pollutantTable;
    }

    /**
     * 获取Excel表格
     * @param device
     * @param interval
     * @param startTime
     * @param endTime
     * @param unit
     * @param pollutantTypeAndAlerm
     * @return
     */
    public Workbook getPollutantExcel( Device device, String interval, String startTime, String endTime, String unit, String pollutantTypeAndAlerm) {
        Workbook wb=new HSSFWorkbook();
        //封装参数
        HashMap<String,Object> param=new HashMap<>();
        param.put("startTime",startTime);
        param.put("endTime",endTime);
        //封装表名
        param.put("pollutantTable",device.getPollutantTable()+interval);
        //封装pollutantType和Alerm参数
        this.setPollutantTypeAndAlermParam(pollutantTypeAndAlerm,param);


        //倒序显示
        param.put("desc",true);

        //根据参数获取浓度列表
        List<Pollutant> pollutantList=pollutantDAO.listPollutant(param);

        //进行单位换算
        if("umgm".equals(unit)){
            PollutantUtil.transformUnit(pollutantList);
        }

        //获取表格头部
        List<String> excelHeader= ExcelUtil.getExcelHeader((String) param.get("pollutantType"),unit);

        //填充表格内容
        ExcelUtil.fullExcelData(pollutantList,excelHeader,wb);

        return wb;

    }

    /**
     * 判断是否存在浓度表
     * @param pollutantTable
     * @return
     */
    public Result isExistPollutantTable(String pollutantTable){
        Integer existPollutantTable = pollutantDAO.isExistPollutantTable(StringUtil.formatSQLLikeRight(pollutantTable+"#_"));
        if(existPollutantTable>0){
            return Result.isOK();
        }else{
            return Result.isNotOK(ResultEnum.POLLUTANT_TABLE_NULL.getInfo());
        }
    }


    /**
     * 封装pollutantType和Alerm参数
     * @param pollutantTypeAndAlerm
     * @param param
     * @return
     */
    private HashMap<String,Object> setPollutantTypeAndAlermParam(String pollutantTypeAndAlerm,HashMap<String,Object> param){

        //定义type封装参数
        StringBuilder typeParam=new StringBuilder(POLLUTANT_TYPE_BASE);
        String[] typeAndAlarmArr=pollutantTypeAndAlerm.split(",");
        //遍历typeAndAlarmArr，设置各个alerm
        for(String typeAndAlarm:typeAndAlarmArr){
            String type=typeAndAlarm.split("-")[0];

            //如果不带参数，则设置空
            if("-".equals(typeAndAlarm.substring(typeAndAlarm.length()-1,typeAndAlarm.length()))){
                param.put(type,"");
            }else{
                String alarm=typeAndAlarm.split("-")[1];

                param.put(type,alarm);
            }
            typeParam.append(type+",");
        }
        //去除最后一个逗号，设置参数type
        String pollutantType=typeParam.toString();
        pollutantType = pollutantType.substring(0,pollutantType.length()-1);
        param.put("pollutantType",pollutantType);
        return param;
    }

    /**
     * 获取最新的30条数据
     * @param displayConfig
     * @param device
     * @return
     */
    public List<Pollutant> listRealPollutant(DisplayConfig displayConfig,Device device){
        HashMap<String,Object> param=new HashMap<>();
        String pollutantType="*";
        String pollutantTable=device.getPollutantTable()+PollutantUtil.getNewestPostfix(displayConfig);
        Integer start=0;
        Integer pageSize=30;
        String desc="desc";
        param.put("pollutantType",pollutantType);
        param.put("pollutantTable",pollutantTable);
        param.put("start",start);
        param.put("pageSize",pageSize);
        param.put("desc",desc);
        List<Pollutant> pollutantList = pollutantDAO.listPollutant(param);
        return pollutantList;
    }

    public Integer isExistColumn(HashMap map){
        return pollutantDAO.isExistColumn(map);
    }


}
