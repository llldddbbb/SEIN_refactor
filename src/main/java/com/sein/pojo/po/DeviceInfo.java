package com.sein.pojo.po;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "device_info_new")
public class DeviceInfo {
    private Long index;

    @Column(name = "DeviceName")
    private String deviceName;

    @Column(name = "StartTime")
    private Date startTime;

    @Column(name = "EndTime")
    private Date endTime;

    private String NO_Code;

    private String NO2_Code;

    private String CO_Code;

    private String CO2_Code;

    private String SO2_Code;

    @Column(name = "O3_Code")
    private String o3_Code;

    private String VOC_Code;

    private String PM1_Code;

    private String PM25_Code;

    private String PM10_Code;

    @Column(name = "Recorder")
    private String recorder;

    @Column(name = "Project")
    private String project;

    /**
     * @return index
     */
    public Long getIndex() {
        return index;
    }

    /**
     * @param index
     */
    public void setIndex(Long index) {
        this.index = index;
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
     * @return NO_Code
     */
    public String getNO_Code() {
        return NO_Code;
    }

    /**
     * @param NO_Code
     */
    public void setNO_Code(String NO_Code) {
        this.NO_Code = NO_Code;
    }

    /**
     * @return NO2_Code
     */
    public String getNO2_Code() {
        return NO2_Code;
    }

    /**
     * @param NO2_Code
     */
    public void setNO2_Code(String NO2_Code) {
        this.NO2_Code = NO2_Code;
    }

    /**
     * @return CO_Code
     */
    public String getCO_Code() {
        return CO_Code;
    }

    /**
     * @param CO_Code
     */
    public void setCO_Code(String CO_Code) {
        this.CO_Code = CO_Code;
    }

    /**
     * @return CO2_Code
     */
    public String getCO2_Code() {
        return CO2_Code;
    }

    /**
     * @param CO2_Code
     */
    public void setCO2_Code(String CO2_Code) {
        this.CO2_Code = CO2_Code;
    }

    /**
     * @return SO2_Code
     */
    public String getSO2_Code() {
        return SO2_Code;
    }

    /**
     * @param SO2_Code
     */
    public void setSO2_Code(String SO2_Code) {
        this.SO2_Code = SO2_Code;
    }

    /**
     * @return O3_Code
     */
    public String getO3_Code() {
        return o3_Code;
    }

    /**
     * @param o3_Code
     */
    public void setO3_Code(String o3_Code) {
        this.o3_Code = o3_Code;
    }

    /**
     * @return VOC_Code
     */
    public String getVOC_Code() {
        return VOC_Code;
    }

    /**
     * @param VOC_Code
     */
    public void setVOC_Code(String VOC_Code) {
        this.VOC_Code = VOC_Code;
    }

    /**
     * @return PM1_Code
     */
    public String getPM1_Code() {
        return PM1_Code;
    }

    /**
     * @param PM1_Code
     */
    public void setPM1_Code(String PM1_Code) {
        this.PM1_Code = PM1_Code;
    }

    /**
     * @return PM25_Code
     */
    public String getPM25_Code() {
        return PM25_Code;
    }

    /**
     * @param PM25_Code
     */
    public void setPM25_Code(String PM25_Code) {
        this.PM25_Code = PM25_Code;
    }

    /**
     * @return PM10_Code
     */
    public String getPM10_Code() {
        return PM10_Code;
    }

    /**
     * @param PM10_Code
     */
    public void setPM10_Code(String PM10_Code) {
        this.PM10_Code = PM10_Code;
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
     * @return Project
     */
    public String getProject() {
        return project;
    }

    /**
     * @param project
     */
    public void setProject(String project) {
        this.project = project;
    }
}