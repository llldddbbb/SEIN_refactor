package com.sein.pojo.po;

import javax.persistence.Column;
import java.util.Date;

public class Equation {
    @Column(name = "Item")
    private Integer item;

    @Column(name = "Code")
    private String code;

    @Column(name = "StartTime")
    private Date startTime;

    @Column(name = "EndTime")
    private Date endTime;

    private Float a;

    private Float b;

    private Float c;

    private Float d;

    private Float e;

    private Float f;

    private Float i;

    private Float a_1;

    @Column(name = "Validity")
    private Float validity;

    @Column(name = "Recorder")
    private String recorder;

    @Column(name = "Remark")
    private String remark;

    @Column(name = "DeviceName")
    private String deviceName;

    /**
     * @return Item
     */
    public Integer getItem() {
        return item;
    }

    /**
     * @param item
     */
    public void setItem(Integer item) {
        this.item = item;
    }

    /**
     * @return Code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return StartTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return EndTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return a
     */
    public Float getA() {
        return a;
    }

    /**
     * @param a
     */
    public void setA(Float a) {
        this.a = a;
    }

    /**
     * @return b
     */
    public Float getB() {
        return b;
    }

    /**
     * @param b
     */
    public void setB(Float b) {
        this.b = b;
    }

    /**
     * @return c
     */
    public Float getC() {
        return c;
    }

    /**
     * @param c
     */
    public void setC(Float c) {
        this.c = c;
    }

    /**
     * @return d
     */
    public Float getD() {
        return d;
    }

    /**
     * @param d
     */
    public void setD(Float d) {
        this.d = d;
    }

    /**
     * @return e
     */
    public Float getE() {
        return e;
    }

    /**
     * @param e
     */
    public void setE(Float e) {
        this.e = e;
    }

    /**
     * @return f
     */
    public Float getF() {
        return f;
    }

    /**
     * @param f
     */
    public void setF(Float f) {
        this.f = f;
    }

    /**
     * @return i
     */
    public Float getI() {
        return i;
    }

    /**
     * @param i
     */
    public void setI(Float i) {
        this.i = i;
    }

    /**
     * @return a_1
     */
    public Float getA_1() {
        return a_1;
    }

    /**
     * @param a_1
     */
    public void setA_1(Float a_1) {
        this.a_1 = a_1;
    }

    /**
     * @return Validity
     */
    public Float getValidity() {
        return validity;
    }

    /**
     * @param validity
     */
    public void setValidity(Float validity) {
        this.validity = validity;
    }

    /**
     * @return Recorder
     */
    public String getRecorder() {
        return recorder;
    }

    /**
     * @param recorder
     */
    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    /**
     * @return Remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return DeviceName
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * @param deviceName
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}