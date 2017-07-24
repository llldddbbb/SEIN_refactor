package com.sein.service;

import com.sein.dao.sein.DurationDAO;
import com.sein.pojo.po.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ldb on 2017/7/12.
 */
@Service
public class DurationService {

    @Autowired
    private DurationDAO durationDAO;

    /**
     * 获取时间段
     * @param accountId
     * @return
     */
    public List<Duration> listDuration(Integer accountId){
        Duration selectParam =new Duration();
        selectParam.setAccountId(accountId);
        return durationDAO.select(selectParam);
    }
}
