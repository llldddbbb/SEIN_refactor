package com.sein.service;

import com.sein.dao.DisplayConfigDAO;
import com.sein.pojo.po.DisplayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * Created by ldb on 2017/7/12.
 */
@Service
public class DisplayConfigService {

    @Autowired
    private DisplayConfigDAO displayConfigDAO;

    /**
     * 获取显示配置表
     * @param accountId
     * @return
     */
    public DisplayConfig getDisplayConfig(Integer accountId){
        Example example=new Example(DisplayConfig.class);
        example.createCriteria().andEqualTo("id",accountId);
        return displayConfigDAO.selectByExample(example).get(0);
    }
}
