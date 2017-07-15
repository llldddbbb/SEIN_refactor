package com.sein.service;

import com.sein.dao.DeviceDAO;
import com.sein.dao.PollutantDAO;
import com.sein.pojo.dto.PageBean;
import com.sein.pojo.dto.PollutantTable;
import com.sein.pojo.po.Device;
import com.sein.pojo.po.Pollutant;
import com.sein.service.utils.ExcelUtil;
import com.sein.service.utils.PageUtil;
import com.sein.service.utils.PollutantUtil;
import com.sein.service.utils.TableUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
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

    @Autowired
    private DeviceDAO deviceDAO;

    @Value("${PAGE_SIZE}")
    private Integer PAGE_SIZE;

    @Value("${POLLUTANT_TYPE_BASE}")
    private String POLLUTANT_TYPE_BASE;

    /**
     * 获取网页表格
     * @param id
     * @param interval
     * @param page
     * @param startTime
     * @param endTime
     * @param unit
     * @param pollutantTypeAndAlerm
     * @return
     */
    public PollutantTable getPollutantTable(Integer id, String interval, String page, String startTime, String endTime, String unit, String pollutantTypeAndAlerm) {
        PollutantTable pollutantTable=new PollutantTable();

        //封装参数
        HashMap<String,Object> param=new HashMap<>();
        param.put("startTime",startTime);
        param.put("endTime",endTime);
        //封装pollutantType和Alerm参数
        this.setPollutantTypeAndAlermParam(pollutantTypeAndAlerm,param);
        //封装分页参数
        if(StringUtils.isEmpty(page)){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page),PAGE_SIZE);
        param.put("start",pageBean.getStart()+"");
        param.put("pageSize",pageBean.getPageSize()+"");
        //封装表名
        Device device=deviceDAO.selectByPrimaryKey(id);
        param.put("pollutantTable",device.getPollutantTable()+interval);

        //倒序显示
        param.put("desc",true);

        //根据参数获取浓度列表
        List<Pollutant> pollutantList=pollutantDAO.listPollutant(param);

        //根据需求要求缓慢显示两行
        if("_1min".equals(interval)){
            if(pollutantList.size()>2){
                pollutantList.remove(pollutantList.size()-1);
                pollutantList.remove(pollutantList.size()-1);
            }
        }

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
     * @param id
     * @param interval
     * @param startTime
     * @param endTime
     * @param unit
     * @param pollutantTypeAndAlerm
     * @return
     */
    public Workbook getPollutantExcel(Integer id, String interval, String startTime, String endTime, String unit, String pollutantTypeAndAlerm) {
        Workbook wb=new HSSFWorkbook();
        //封装参数
        HashMap<String,Object> param=new HashMap<>();
        param.put("startTime",startTime);
        param.put("endTime",endTime);
        //封装pollutantType和Alerm参数
        this.setPollutantTypeAndAlermParam(pollutantTypeAndAlerm,param);
        //封装表名
        Device device=deviceDAO.selectByPrimaryKey(id);
        param.put("pollutantTable",device.getPollutantTable()+interval);

        //倒序显示
        param.put("desc",true);

        //根据参数获取浓度列表
        List<Pollutant> pollutantList=pollutantDAO.listPollutant(param);

        //根据需求要求缓慢显示两行
        if("_1min".equals(interval)){
            if(pollutantList.size()>2){
                pollutantList.remove(pollutantList.size()-1);
                pollutantList.remove(pollutantList.size()-1);
            }
        }

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


}
