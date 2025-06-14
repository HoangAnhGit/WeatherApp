package com.example.weatherapp.Respository;

import retrofit2.Call;

import com.example.weatherapp.Model.CurrentResponseApi;
import com.example.weatherapp.Server.ApiServices;

public class WeatherRepository {
    private final ApiServices api;
    private final String KEY_API = "Builder";
    public WeatherRepository(ApiServices api) {
        this.api = api;
    }


    public Call<CurrentResponseApi> getCurrentWeather(double lat, double lng, String unit) {
        return api.getCurrentWeather(
                String.valueOf(lat),
                String.valueOf(lng),
                unit,
                KEY_API);
    }
}
