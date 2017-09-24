package com.ming.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by llm on 2017/9/22 0022.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt")
        public String info;
    }
}
