package com.ming.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by llm on 2017/9/22 0022.
 */

public class Forecast {

    public String date;

    @SerializedName("cond")
    public More more;

    @SerializedName("tmp")
    public Temperature temperature;

    public class Temperature {
        public String max;
        public String min;
    }
    public class More{
        @SerializedName("txt_d")
        public String info;
    }



}
