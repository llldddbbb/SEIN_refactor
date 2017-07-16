package com.sein.service.utils;

/**
 * Created by ldb on 2017/7/13.
 */
public class StringUtil {
    /**
     * 格式化搜索字符，支持模糊查询
     * @param str
     * @return
     */
    public static String formatSQLLikeStr(String str){
        return "%"+str+"%";
    }

    public static String formatSQLLikeRight(String str){
        return str+"%";
    }
}
