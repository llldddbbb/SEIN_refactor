package com.sein.pojo.po;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Id;

public class DisplayConfig {
    @Id
    private Integer id;

    @JsonProperty("PM25")
    private Integer pm25=0;


    @JsonProperty("PM1")
    private Integer pm1=0;

    @JsonProperty("PM10")
    private Integer pm10=0;

    @JsonProperty("CO")
    private Integer co=0;

    @JsonProperty("CO2")
    private Integer co2=0;

    @JsonProperty("SO")
    private Integer so=0;

    @JsonProperty("SO2")
    private Integer so2=0;

    @JsonProperty("NO")
    private Integer no=0;

    @JsonProperty("NO2")
    private Integer no2=0;

    @JsonProperty("O3")
    private Integer o3=0;

    @JsonProperty("CL2")
    private Integer cl2=0;

    @JsonProperty("VOC")
    private Integer voc=0;

    @JsonProperty("Temp")
    private Integer temp=0;

    @JsonProperty("Humi")
    private Integer humi=0;

    @JsonProperty("Longitude")
    private Integer longitude=0;

    @JsonProperty("Latitude")
    private Integer latitude=0;

    @JsonProperty("Press")
    private Integer press=0;

    @JsonProperty("AQI")
    private Integer aqi=0;

    @JsonProperty("AQHI")
    private Integer aqhi=0;

    @Column(name = "1min")
    @JsonProperty("1min")
    private Integer min1=0;

    @Column(name = "10min")
    @JsonProperty("10min")
    private Integer min10=0;

    @Column(name = "15min")
    @JsonProperty("15min")
    private Integer min15=0;

    @Column(name = "30min")
    @JsonProperty("30min")
    private Integer min30=0;

    @Column(name = "1h")
    @JsonProperty("1h")
    private Integer h1=0;

    @Column(name = "1d")
    @JsonProperty("1d")
    private Integer d1=0;

    @JsonProperty("original")
    private Integer original=0;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPm25() {
        return pm25;
    }

    public void setPm25(Integer pm25) {
        this.pm25 = pm25;
    }

    public Integer getPm10() {
        return pm10;
    }

    public void setPm10(Integer pm10) {
        this.pm10 = pm10;
    }

    public Integer getCo() {
        return co;
    }

    public void setCo(Integer co) {
        this.co = co;
    }

    public Integer getCo2() {
        return co2;
    }

    public void setCo2(Integer co2) {
        this.co2 = co2;
    }

    public Integer getSo() {
        return so;
    }

    public void setSo(Integer so) {
        this.so = so;
    }

    public Integer getSo2() {
        return so2;
    }

    public void setSo2(Integer so2) {
        this.so2 = so2;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getNo2() {
        return no2;
    }

    public void setNo2(Integer no2) {
        this.no2 = no2;
    }

    public Integer getO3() {
        return o3;
    }

    public void setO3(Integer o3) {
        this.o3 = o3;
    }

    public Integer getCl2() {
        return cl2;
    }

    public void setCl2(Integer cl2) {
        this.cl2 = cl2;
    }

    public Integer getVoc() {
        return voc;
    }

    public void setVoc(Integer voc) {
        this.voc = voc;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getHumi() {
        return humi;
    }

    public void setHumi(Integer humi) {
        this.humi = humi;
    }

    public Integer getAqi() {
        return aqi;
    }

    public void setAqi(Integer aqi) {
        this.aqi = aqi;
    }

    public Integer getAqhi() {
        return aqhi;
    }

    public void setAqhi(Integer aqhi) {
        this.aqhi = aqhi;
    }

    public Integer getMin1() {
        return min1;
    }

    public void setMin1(Integer min1) {
        this.min1 = min1;
    }

    public Integer getMin10() {
        return min10;
    }

    public void setMin10(Integer min10) {
        this.min10 = min10;
    }

    public Integer getMin15() {
        return min15;
    }

    public void setMin15(Integer min15) {
        this.min15 = min15;
    }

    public Integer getMin30() {
        return min30;
    }

    public void setMin30(Integer min30) {
        this.min30 = min30;
    }

    public Integer getH1() {
        return h1;
    }

    public void setH1(Integer h1) {
        this.h1 = h1;
    }

    public Integer getD1() {
        return d1;
    }

    public void setD1(Integer d1) {
        this.d1 = d1;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getPress() {
        return press;
    }

    public void setPress(Integer press) {
        this.press = press;
    }

    public Integer getPm1() {
        return pm1;
    }

    public void setPm1(Integer pm1) {
        this.pm1 = pm1;
    }

    public Integer getOriginal() {
        return original;
    }

    public void setOriginal(Integer original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return "DisplayConfigPO{" +
                "id=" + id +
                ", pm25=" + pm25 +
                ", pm10=" + pm10 +
                ", co=" + co +
                ", co2=" + co2 +
                ", so=" + so +
                ", so2=" + so2 +
                ", no=" + no +
                ", no2=" + no2 +
                ", o3=" + o3 +
                ", cl2=" + cl2 +
                ", voc=" + voc +
                ", temp=" + temp +
                ", humi=" + humi +
                ", aqi=" + aqi +
                ", aqhi=" + aqhi +
                ", min1=" + min1 +
                ", min10=" + min10 +
                ", min15=" + min15 +
                ", min30=" + min30 +
                ", h1=" + h1 +
                ", d1=" + d1 +
                '}';
    }

    public DisplayConfig() {
    }

    public DisplayConfig(Integer pm25, Integer pm10, Integer co, Integer co2, Integer no, Integer no2, Integer o3, Integer temp, Integer humi, Integer min1, Integer min10) {
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.co = co;
        this.co2 = co2;
        this.no = no;
        this.no2 = no2;
        this.o3 = o3;
        this.temp = temp;
        this.humi = humi;
        this.min1=min1;
        this.min10=min10;
    }
}