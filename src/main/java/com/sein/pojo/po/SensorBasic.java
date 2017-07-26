package com.sein.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sensor_basic")
public class SensorBasic {
    @Id
    @Column(name = "Code")
    private String code;

    @Column(name = "Type")
    private String type;

    @Column(name = "Mode")
    private String mode;

    @Column(name = "FactorySN")
    private String factorySN;

    @Column(name = "ArriveDate")
    private Date arriveDate;

    @Column(name = "Supplier")
    private String supplier;

    @Column(name = "Recorder")
    private String recorder;

    @Column(name = "Remark")
    private String remark;

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
     * @return Type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return Mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * @param mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * @return FactorySN
     */
    public String getFactorySN() {
        return factorySN;
    }

    /**
     * @param factorySN
     */
    public void setFactorySN(String factorySN) {
        this.factorySN = factorySN;
    }

    /**
     * @return ArriveDate
     */
    public Date getArriveDate() {
        return arriveDate;
    }

    /**
     * @param arriveDate
     */
    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    /**
     * @return Supplier
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * @param supplier
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier;
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
}