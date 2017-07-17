package com.sein.service;

import com.sein.dao.DeviceDAO;
import com.sein.pojo.dto.DevicePollutant;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.Device;
import com.sein.pojo.po.DisplayConfig;
import com.sein.utils.JacksonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by ldb on 2017/7/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DevicePollutantServiceTest {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DevicePollutantService devicePollutantService;

    @Autowired
    private DisplayConfigService displayConfigService;

    @Autowired
    private DeviceDAO deviceDAO;

    @Test
    public void testGetDevicesConfig(){
        // Device device=new Device();
        // device.setAccountId(2);
        // List<Device> deviceList = deviceDAO.select(device);
        // Result devicesConfig = devicePollutantService.getDevicesConfig(deviceList);
        // logger.info(JacksonUtil.toJSon(devicesConfig));
    }
}
