package com.sein.service.utils;

import com.sein.pojo.dto.TransformGPSResult;
import com.sein.utils.JacksonUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ldb on 2017/6/18.
 */
public class TransformGPSUtil {

    public static TransformGPSResult transformBD(double longitude, double latitude) {
        try {
            String AK = "Um05HtLey0wwsiGAy01LWoQu9KaMAaEq";
            String url = "http://api.map.baidu.com/geoconv/v1/?coords=" + longitude + "," + latitude + "&from=1&to=5&ak=" + AK;
            URL realUrl;
            realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.connect();
            String result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "UTF-8"));
            String line = "";
            while ((line = in.readLine()) != null) {
                result += line;
            }
            TransformGPSResult transformGPSResult= JacksonUtil.readValue(result,TransformGPSResult.class);
            return transformGPSResult;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
