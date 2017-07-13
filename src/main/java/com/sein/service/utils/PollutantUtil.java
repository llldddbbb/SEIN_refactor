package com.sein.service.utils;

import com.sein.pojo.dto.PollutantChartItem;
import com.sein.pojo.dto.PollutantItem;
import com.sein.pojo.po.DisplayConfig;
import com.sein.pojo.po.Pollutant;
import com.sein.utils.DateUtil;
import com.sein.utils.DecimalUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldb on 2017/7/13.
 * 浓度工具类:封装污染物等
 */
public class PollutantUtil {

    /**
     * 获取最新的表格后缀
     *
     * @param displayConfig
     * @return
     */
    public static String getNewestPostfix(DisplayConfig displayConfig) {
        String postfix = "_1min";
        if (displayConfig.getOriginal() == 1) {
            postfix = "_original";
        } else if (displayConfig.getMin1() == 1) {
            postfix = "_1min";
        } else if (displayConfig.getMin10() == 1) {
            postfix = "_10min";
        } else if (displayConfig.getMin15() == 1) {
            postfix = "_15min";
        } else if (displayConfig.getMin30() == 1) {
            postfix = "_30min";
        } else if (displayConfig.getH1() == 1) {
            postfix = "_1h";
        } else if (displayConfig.getD1() == 1) {
            postfix = "_1d";
        }
        return postfix;
    }


    /**
     * 封装PollutantItemList
     *
     * @param displayConfig
     * @param pollutant
     * @return
     */
    public static List<PollutantItem> getPollutantItemList(DisplayConfig displayConfig, Pollutant pollutant) {
        List<PollutantItem> itemList = new ArrayList<>();
        //添加时间
        itemList.add(new PollutantItem("time", DateUtil.formatStrToStr(pollutant.getTime(), "yyyy-MM-dd HH:mm:ss")));
        if (displayConfig.getPm25() == 1) {
            if (pollutant.getPm25() == null) {
                itemList.add(new PollutantItem("PM25", null));
            } else {
                if (pollutant.getPm25() < 0) {
                    itemList.add(new PollutantItem("PM25", null));
                } else {
                    itemList.add(new PollutantItem("PM25", DecimalUtil.formatDecimal(pollutant.getPm25(),"#.#").toString()));
            }
            }
        }
        if (displayConfig.getPm10() == 1) {
            if (pollutant.getPm10() == null) {
                itemList.add(new PollutantItem("PM10", null));
            } else {
                if (pollutant.getPm10() < 0) {
                    itemList.add(new PollutantItem("PM10", null));
                } else {
                    itemList.add(new PollutantItem("PM10", DecimalUtil.formatDecimal(pollutant.getPm10(),"#.#").toString()));
                }
            }
        }
        if (displayConfig.getPm1() == 1) {
            if (pollutant.getPm1() == null) {
                itemList.add(new PollutantItem("PM1", null));
            } else {
                if (pollutant.getPm1() < 0) {
                    itemList.add(new PollutantItem("PM1", null));
                } else {
                    itemList.add(new PollutantItem("PM1", DecimalUtil.formatDecimal(pollutant.getPm1(),"#.#").toString()));
                }
            }
        }
        if (displayConfig.getCo() == 1) {
            if (pollutant.getCo() == null) {
                itemList.add(new PollutantItem("CO", null));
            } else {
                if (pollutant.getCo() < 0) {
                    itemList.add(new PollutantItem("CO", null));
                } else {
                    itemList.add(new PollutantItem("CO", DecimalUtil.formatDecimal(pollutant.getCo(),"#.###").toString()));
                }
            }
        }
        if (displayConfig.getCo2() == 1) {
            if (pollutant.getCo2() == null) {
                itemList.add(new PollutantItem("CO2", null));
            } else {
                if (pollutant.getCo2() < 0) {
                    itemList.add(new PollutantItem("CO2", null));
                } else {
                    itemList.add(new PollutantItem("CO2", DecimalUtil.formatDecimal(pollutant.getCo2(),"#.###").toString()));
                }
            }
        }
        if (displayConfig.getNo() == 1) {
            if (pollutant.getNo() == null) {
                itemList.add(new PollutantItem("NO", null));
            } else {
                if (pollutant.getNo() < 0) {
                    itemList.add(new PollutantItem("NO", null));
                } else {
                    itemList.add(new PollutantItem("NO", DecimalUtil.formatDecimal(pollutant.getNo(),"#.#").toString()));
                }
            }
        }
        if (displayConfig.getNo2() == 1) {
            if (pollutant.getNo2() == null) {
                itemList.add(new PollutantItem("NO2", null));
            } else {
                if (pollutant.getNo2() < 0) {
                    itemList.add(new PollutantItem("NO2", null));
                } else {
                    itemList.add(new PollutantItem("NO2", DecimalUtil.formatDecimal(pollutant.getNo2(),"#.#").toString()));
                }
            }
        }
        if (displayConfig.getSo() == 1) {
            if (pollutant.getSo() == null) {
                itemList.add(new PollutantItem("SO", null));
            } else {
                if (pollutant.getSo() < 0) {
                    itemList.add(new PollutantItem("SO", null));
                } else {
                    itemList.add(new PollutantItem("SO", DecimalUtil.formatDecimal(pollutant.getSo(),"#.#").toString()));
                }
            }
        }
        if (displayConfig.getSo2() == 1) {
            if (pollutant.getSo2() == null) {
                itemList.add(new PollutantItem("SO2", null));
            } else {
                if (pollutant.getSo2() < 0) {
                    itemList.add(new PollutantItem("SO2", null));
                } else {
                    itemList.add(new PollutantItem("SO2", DecimalUtil.formatDecimal(pollutant.getSo2(),"#.#").toString()));
                }
            }
        }
        if (displayConfig.getO3() == 1) {
            if (pollutant.getO3() == null) {
                itemList.add(new PollutantItem("O3", null));
            } else {
                if (pollutant.getO3() < 0) {
                    itemList.add(new PollutantItem("O3", null));
                } else {
                    itemList.add(new PollutantItem("O3", DecimalUtil.formatDecimal(pollutant.getO3(),"#.#").toString()));
                }
            }
        }
        if (displayConfig.getCl2() == 1) {
            if (pollutant.getCl2() == null) {
                itemList.add(new PollutantItem("CL2", null));
            } else {
                if (pollutant.getCl2() < 0) {
                    itemList.add(new PollutantItem("CL2", null));
                } else {
                    itemList.add(new PollutantItem("CL2", DecimalUtil.formatDecimal(pollutant.getCl2(),"#.#").toString()));
                }
            }
        }
        if (displayConfig.getVoc() == 1) {
            if (pollutant.getVoc() == null) {
                itemList.add(new PollutantItem("VOC", null));
            } else {
                if (pollutant.getVoc() < 0) {
                    itemList.add(new PollutantItem("VOC", null));
                } else {
                    itemList.add(new PollutantItem("VOC", DecimalUtil.formatDecimal(pollutant.getVoc(),"#.#").toString()));
                }
            }
        }
        if (displayConfig.getPress() == 1) {
            if (pollutant.getPress() == null) {
                itemList.add(new PollutantItem("Press", null));
            } else {
                if (pollutant.getPress() < 0) {
                    itemList.add(new PollutantItem("Press", null));
                } else {
                    itemList.add(new PollutantItem("Press", DecimalUtil.formatDecimal(pollutant.getPress(),"#.#").toString()));
                }
            }
        }
        if (displayConfig.getTemp() == 1) {
            if (pollutant.getTemp() == null) {
                itemList.add(new PollutantItem("Temp", null));
            } else {
                if (pollutant.getTemp() < 0) {
                    itemList.add(new PollutantItem("Temp", null));
                } else {
                    itemList.add(new PollutantItem("Temp", DecimalUtil.formatDecimal(pollutant.getTemp(),"#.#").toString()));
                }
            }
        }
        if (displayConfig.getHumi() == 1) {
            if (pollutant.getHumi() == null) {
                itemList.add(new PollutantItem("Humi", null));
            } else {
                if (pollutant.getHumi() < 0) {
                    itemList.add(new PollutantItem("Humi", null));
                } else {
                    itemList.add(new PollutantItem("Humi", DecimalUtil.formatDecimal(pollutant.getHumi(),"#.#").toString()));
                }
            }
        }

        return itemList;

    }


    public static List<PollutantChartItem> getPollutantChartList(String pollutantType,List<Pollutant> pollutantList) {
        List<PollutantChartItem> itemList = new ArrayList<>();
        //遍历浓度表，封装成前台折线图需要的time-value列表
        for (Pollutant pollutant : pollutantList) {
            PollutantChartItem item = new PollutantChartItem();
            //封装time
            item.setTime(DateUtil.formatStrToStr(pollutant.getTime(), "MM-dd HH:mm:ss"));
            switch (pollutantType) {
                case "PM25":
                    item.setValue(pollutant.getPm25() == null ? null : pollutant.getPm25() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getPm25(),"#.#"));
                    break;
                case "PM10":
                    item.setValue(pollutant.getPm10() == null ? null : pollutant.getPm10() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getPm10(),"#.#"));
                    break;
                case "PM1":
                    item.setValue(pollutant.getPm1() == null ? null : pollutant.getPm1() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getPm1(),"#.#"));
                    break;
                case "CO":
                    item.setValue(pollutant.getCo() == null ? null : pollutant.getCo() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getCo(),"#.###"));
                    break;
                case "CO2":
                    item.setValue(pollutant.getCo2() == null ? null : pollutant.getCo2() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getCo2(),"#.###"));
                    break;
                case "NO":
                    item.setValue(pollutant.getNo() == null ? null : pollutant.getNo() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getNo(),"#.#"));
                    break;
                case "NO2":
                    item.setValue(pollutant.getNo2() == null ? null : pollutant.getNo2() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getNo2(),"#.#"));
                    break;
                case "SO":
                    item.setValue(pollutant.getSo() == null ? null : pollutant.getSo() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getSo(),"#.#"));
                    break;
                case "SO2":
                    item.setValue(pollutant.getSo2() == null ? null : pollutant.getSo2() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getSo2(),"#.#"));
                    break;
                case "CL2":
                    item.setValue(pollutant.getCl2() == null ? null : pollutant.getCl2() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getCl2(),"#.#"));
                    break;
                case "O3":
                    item.setValue(pollutant.getO3() == null ? null : pollutant.getO3() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getO3(),"#.#"));
                    break;
                case "VOC":
                    item.setValue(pollutant.getVoc() == null ? null : pollutant.getVoc() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getVoc(),"#.#"));
                    break;
                case "Press":
                    item.setValue(pollutant.getPress() == null ? null : pollutant.getPress() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getPress(),"#.#"));
                    break;
                case "Humi":
                    item.setValue(pollutant.getHumi() == null ? null : pollutant.getHumi() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getHumi(),"#.#"));
                    break;
                case "Temp":
                    item.setValue(pollutant.getTemp() == null ? null : pollutant.getTemp() < 0 ? null : DecimalUtil.formatDecimal(pollutant.getTemp(),"#.#"));
                    break;
            }
            itemList.add(item);
        }
        return itemList;
    }
}
