package com.sein.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by ldb on 2017/5/3.
 */
public class DecimalUtil {

    /**
     * 四舍五入类
     * @param d
     * @param type
     * @return
     */
    public static Double formatDecimal(Double d,String type){
        DecimalFormat df = new DecimalFormat(type);
        df.setRoundingMode(RoundingMode.HALF_UP);
        return Double.parseDouble(df.format(d));
    }
}
