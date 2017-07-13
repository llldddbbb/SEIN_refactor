package com.sein.service;

import com.sein.dao.DeviceDAO;
import com.sein.dao.PollutantDAO;
import com.sein.pojo.dto.DevicePollutant;
import com.sein.pojo.dto.PollutantItem;
import com.sein.pojo.po.Device;
import com.sein.pojo.po.DisplayConfig;
import com.sein.pojo.po.Pollutant;
import com.sein.service.utils.DevicePollutantUtil;
import com.sein.service.utils.PollutantUtil;
import com.sein.service.utils.StringUtil;
import com.sein.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
            DevicePollutantUtil.setStatus(devicePollutant,pollutant.getTime());
            devicePollutantList.add(devicePollutant);
        }
        return devicePollutantList;
    }

}
