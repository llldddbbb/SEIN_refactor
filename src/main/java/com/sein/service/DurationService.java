package com.sein.service;

import com.sein.dao.DurationDAO;
import com.sein.pojo.po.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ldb on 2017/7/12.
 */
@Service
public class DurationService {

    @Autowired
    private DurationDAO durationDAO;

    public Duration getDuration(Integer accountId){
        Duration selectParam =new Duration();
        selectParam.setAccountId(accountId);
        return durationDAO.selectOne(selectParam);
    }
}
