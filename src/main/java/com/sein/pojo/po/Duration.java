package com.sein.pojo.po;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by ldb on 2017/5/16.
 */
public class Duration {

    private Integer id;

    @Column(name = "startTime")
    private Date startTime;

    @Column(name = "endTime")
    private Date endTime;

    @Column(name = "durationName")
    private String durationName;

    @Column(name = "accountId")
    private Integer accountId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getDurationName() {
        return durationName;
    }

    public void setDurationName(String durationName) {
        this.durationName = durationName;
    }
}
