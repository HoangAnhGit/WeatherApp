package com.example.weatherapp.Server;

import com.example.weatherapp.Model.CurrentResponseApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("/data/2.5/weather")
    Call<CurrentResponseApi> getCurrentWeather(@Query("lat") String lat,
                                               @Query("lon") String lon,
                                               @Query("unit") String unit,
                                               @Query("appid") String key);

}
