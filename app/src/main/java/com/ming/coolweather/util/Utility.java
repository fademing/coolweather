package com.ming.coolweather.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.ming.coolweather.db.City;
import com.ming.coolweather.db.County;
import com.ming.coolweather.db.Province;
import com.ming.coolweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/9/21 0021.
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     *
     * @param response
     * @return
     */
    public static boolean handleProviceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvices = new JSONArray(response);
                for (int i = 0; i < allProvices.length(); i++) {
                    JSONObject proviceObject = allProvices.getJSONObject(i);
                    Province province = new Province();
                    province.setProviceName(proviceObject.getString("name"));
                    province.setProviceCode(proviceObject.getInt("id"));
                    province.save();
                }

                return true;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     *
     * @param response
     * @return
     */
    public static boolean handleCityResponse(String response, int proviceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCitys = new JSONArray(response);
                for (int i = 0; i < allCitys.length(); i++) {
                    JSONObject cityObject = allCitys.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(proviceId);
                    city.save();
                }

                return true;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 将放回的json数据解析成Weather实体类
     */
    public static Weather handleWeatherResponse(String response){

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.get(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

}
