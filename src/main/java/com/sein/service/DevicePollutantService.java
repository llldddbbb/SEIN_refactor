package com.sein.service;

import com.sein.dao.DeviceDAO;
import com.sein.dao.PollutantDAO;
import com.sein.pojo.dto.DevicePollutant;
import com.sein.pojo.dto.PollutantChartItem;
import com.sein.pojo.dto.PollutantItem;
import com.sein.pojo.po.Device;
import com.sein.pojo.po.DisplayConfig;
import com.sein.pojo.po.Pollutant;
import com.sein.service.utils.DevicePollutantUtil;
import com.sein.service.utils.PollutantUtil;
import com.sein.service.utils.StringUtil;
import com.sein.utils.AQIUtil;
import com.sein.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/7/13.
 * 设备封装浓度的Service类
 */
@Service
public class DevicePollutantService {

    @Autowired
    private DeviceDAO deviceDAO;

    @Autowired
    private PollutantDAO pollutantDAO;

    @Value("${POLLUTANT_TYPE_BASE}")
    private String POLLUTANT_TYPE_BASE;

    /**
     * 获取设备列表以及相应的最新污染物
     *
     * @param displayConfig
     * @return
     */
    public List<DevicePollutant> listDevicePollutant(DisplayConfig displayConfig,String cityName) {
        List<DevicePollutant> devicePollutantList=new ArrayList<>();

        Example example=new Example(Device.class);

        //cityName进行模糊搜索
        if(!StringUtils.isEmpty(cityName)){
            example.createCriteria().andLike("cityName", StringUtil.formatSQLLikeStr(cityName));
        }
        //查询设备列表
        example.createCriteria().andEqualTo("accountId",displayConfig.getId());
        List<Device> deviceList = deviceDAO.selectByExample(example);

        for(Device device:deviceList){
            DevicePollutant devicePollutant=new DevicePollutant();

            //获取最新后缀参数拼接表格参数
            HashMap<String,Object> param=new HashMap<>();
            String tablePostfix= PollutantUtil.getNewestPostfix(displayConfig);
            param.put("pollutantTable",device.getPollutantTable()+tablePostfix);

            //查询最新一条浓度数据根据数据获取ItemList
            Pollutant pollutant=pollutantDAO.getPollutant(param);
            //如果为空，则设置一个时间，避免异常
            if(pollutant==null){
                pollutant=new Pollutant();
                pollutant.setTime(DateUtil.getCurrentDateStr());
            }
            List<PollutantItem> pollutantItemList = PollutantUtil.getPollutantItemList(displayConfig, pollutant);

            //封装devicePollutant参数并添加
            devicePollutant.setDevice(device);
            devicePollutant.setPollutantItemList(pollutantItemList);
            //设置状态
            DevicePollutantUtil.setStatus(devicePollutant,pollutant.getTime());
            devicePollutantList.add(devicePollutant);
        }
        return devicePollutantList;
    }

    /**
     * 详情页，根据id获取设备及对应浓度
     * @param displayConfig
     * @param id
     * @return
     */
    public DevicePollutant getDevicePollutantById(DisplayConfig displayConfig,Integer id) {
        DevicePollutant devicePollutant=new DevicePollutant();

        Device device=deviceDAO.selectByPrimaryKey(id);

        //获取最新后缀参数拼接表格参数
        HashMap<String,Object> param=new HashMap<>();
        String tablePostfix= PollutantUtil.getNewestPostfix(displayConfig);
        param.put("pollutantTable",device.getPollutantTable()+tablePostfix);

        //查询最新一条浓度数据根据数据获取ItemList
        Pollutant pollutant=pollutantDAO.getPollutant(param);
        //如果为空，则设置一个时间，避免异常
        if(pollutant==null){
            pollutant=new Pollutant();
            pollutant.setTime(DateUtil.getCurrentDateStr());
        }
        List<PollutantItem> pollutantItemList=PollutantUtil.getPollutantItemList(displayConfig,pollutant);

        //计算并获取AQI
        Double AQI= null;
        try {
            AQI = AQIUtil.getAQI(pollutantItemList);
        } catch (Exception e) {
            AQI=0.0;
        }
        //封装devicePollutant参数并添加
        devicePollutant.setAQI((int)Math.floor(AQI)+"");
        devicePollutant.setPollutantItemList(pollutantItemList);
        //设置状态
        DevicePollutantUtil.setStatus(devicePollutant,pollutant.getTime());
        devicePollutant.setDevice(device);
        return devicePollutant;
    }

    /**
     * 详情页的折线图部分，获取折线图数据
     * @param id
     * @param pollutantType
     * @param startTime
     * @param endTime
     * @param interval
     * @return
     */
    public List<PollutantChartItem> listPollutantChart( Integer id,String pollutantType,String startTime,String endTime,String interval) {
        //封装参数
        HashMap<String,Object> pollutantParam=new HashMap<>();
        Device device = deviceDAO.selectByPrimaryKey(id);
        pollutantParam.put("pollutantTable",device.getPollutantTable()+interval);
        //添加DateTime
        pollutantParam.put("pollutantType",this.POLLUTANT_TYPE_BASE+pollutantType);
        pollutantParam.put("startTime",startTime);
        pollutantParam.put("endTime",endTime);
        //查询满足参数的浓度列表
        List<Pollutant> pollutantList=pollutantDAO.listPollutant(pollutantParam);

        List<PollutantChartItem> pollutantChartList = PollutantUtil.getPollutantChartList(pollutantType, pollutantList);
        return pollutantChartList;
    }

}
