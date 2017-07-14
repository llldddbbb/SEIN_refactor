package com.sein.service;

import com.sein.dao.DeviceDAO;
import com.sein.dao.PollutantDAO;
import com.sein.pojo.po.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ldb on 2017/7/12.
 */
@Service
public class DeviceService {

    @Autowired
    private DeviceDAO deviceDAO;

    /**
     * 获取设备列表
     *
     * @param accountId
     * @return
     */
    public List<Device> listDevice(int accountId) {
        Device selectParam = new Device();
        selectParam.setAccountId(accountId);
        return deviceDAO.select(selectParam);
    }

    /**
     * 根据ID获取单个设备
     * @param id
     * @return
     */
    public Device getDevice(int id){
        return deviceDAO.selectByPrimaryKey(id);
    }
}


