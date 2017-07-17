package com.sein.service;

import com.sein.dao.DisplayConfigDAO;
import com.sein.pojo.dto.Result;
import com.sein.pojo.po.DisplayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by ldb on 2017/7/12.
 */
@Service
public class DisplayConfigService {

    @Autowired
    private DisplayConfigDAO displayConfigDAO;

    /**
     * 获取显示配置表
     *
     * @param accountId
     * @return
     */
    public DisplayConfig getDisplayConfig(Integer accountId) {
        Example example = new Example(DisplayConfig.class);
        example.createCriteria().andEqualTo("id", accountId);
        List<DisplayConfig> displayConfigs = displayConfigDAO.selectByExample(example);
        if(displayConfigs!=null&&displayConfigs.size()>0){
            return displayConfigs.get(0);
        }else{
            return null;
        }

    }

    /**
     * 删除配置信息
     * @param id
     * @return
     */
    public int deleteDisplayConfig(int id){
        return displayConfigDAO.deleteByPrimaryKey(id);
    }

    /**
     * 添加一个设备配置信息
     *
     * @param displayConfig
     * @return
     */
    public Result addDeviceConfig(DisplayConfig displayConfig) {
        displayConfigDAO.insert(displayConfig);
        return Result.isOK();
    }
}
