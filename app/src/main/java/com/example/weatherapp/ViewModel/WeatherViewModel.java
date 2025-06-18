package com.example.weatherapp.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.weatherapp.Model.CurrentResponseApi;
import com.example.weatherapp.Respository.WeatherRepository;
import com.example.weatherapp.Server.ApiClient;
import com.example.weatherapp.Server.ApiServices;

import retrofit2.Call;

public class WeatherViewModel extends ViewModel {
    private final WeatherRepository weatherRepository;

    public WeatherViewModel() {
        this.weatherRepository = new WeatherRepository(
                ApiClient.getClient().create(ApiServices.class)
        );
    }

    public Call<CurrentResponseApi> loadCurrentWeather(double lat, double lon, String unit) {
        return weatherRepository.getCurrentWeather(lat, lon, unit);
    }
}
