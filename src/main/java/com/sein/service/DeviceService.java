package com.sein.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sein.dao.AccountDAO;
import com.sein.dao.DeviceDAO;
import com.sein.pojo.dto.PageResult;
import com.sein.pojo.po.Account;
import com.sein.pojo.po.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by ldb on 2017/7/12.
 */
@Service
public class DeviceService {

    @Autowired
    private DeviceDAO deviceDAO;

    @Autowired
    private AccountDAO accountDAO;


    /**
     * 获取某个账户的设备列表
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
     * 获取所有设备封装成分页列表信息
     * @param pageNum
     * @return
     */
    public PageResult<Device> listDevice(int pageNum,int pageSize){
        PageResult<Device> pageResult=new PageResult<>();
        //切入分页sql
        Page<Device> page = PageHelper.startPage(pageNum,pageSize);
        //获取分页后结果
        Example example=new Example(Device.class);
        //倒序排序
        example.setOrderByClause("id DESC");
        List<Device> deviceList =deviceDAO.selectByExample(example);
        for (Device device : deviceList) {
            Account account = accountDAO.selectByPrimaryKey(device.getAccountId());
            device.setAccount(account);
        }
        //获取总记录数
        long total = page.getTotal();
        //封装参数
        pageResult.setRows(deviceList);
        pageResult.setTotal(total);
        return pageResult;
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


