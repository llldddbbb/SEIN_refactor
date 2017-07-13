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

    @Autowired
    private PollutantDAO pollutantDAO;

    /**
     * 获取设备列表
     *
     * @param accountId
     * @return
     */
    public List<Device> getDeviceList(int accountId) {
        Device selectParam = new Device();
        selectParam.setAccountId(accountId);
        return deviceDAO.select(selectParam);
    }
}


