package com.ming.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by llm on 2017/9/22 0022.
 */

public class AQI {

    @SerializedName("city")
    public AQICity aqiCity;

    public class AQICity{
        public String aqi;
        public String pm25;
    }

}
