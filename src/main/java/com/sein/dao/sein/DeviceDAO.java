package com.sein.dao.sein;

import com.sein.pojo.po.Device;
import com.sein.utils.MyMapper;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/7/12.
 */
public interface DeviceDAO extends MyMapper<Device> {

    List<Device> listDeviceWithAccount(HashMap<String,Object> param);

}
