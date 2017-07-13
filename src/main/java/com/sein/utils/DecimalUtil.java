package com.sein.utils;

import java.text.DecimalFormat;

/**
 * Created by ldb on 2017/5/3.
 */
public class DecimalUtil {

    public static Double formatDecimal(Double d,String type){
        DecimalFormat df = new DecimalFormat(type);
        return Double.parseDouble(df.format(d));
    }
}
