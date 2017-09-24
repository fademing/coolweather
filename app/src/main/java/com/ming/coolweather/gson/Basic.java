package com.ming.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by llm on 2017/9/22 0022.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
